package com.example.demo

import com.example.demo.data.models.Bank
import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.Matchers
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

/***
note that we don't have a BankController instance in our test class since we are using @SpringBootTest annotation which launches
our entire application and then we use the BankController instance that is made . then we use [mockMvc] object to send mock
request call to our applications endpoints
 */

@SpringBootTest
@AutoConfigureMockMvc
internal class BankTestController @Autowired constructor(
  // we could do bean injection here or as lateinit var
  @Autowired
  val objectMapper: ObjectMapper,
  val justAnotherBean: ObjectMapper // this one also will be injected since constructor has @Autowired annotation
) {

  @Autowired
  lateinit var mockMvc: MockMvc

  @Nested
  @DisplayName("GET /api/banks")
  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
  inner class GetBank {
    @Test
    fun `should return the bank with the given account number`() {
      // given
      val accountNumber = "1234"
      // when
      mockMvc.get("/api/banks/$accountNumber")
        .andExpect {
          status { isOk() }
          content {
            contentType(MediaType.APPLICATION_JSON)
          }
          jsonPath("$.accountNumber", Matchers.equalTo(accountNumber))
        }
    }

    @Test
    fun `should return NOT FOUND if the given account number does not exist`() {
      // given
      val accountNumber = "00000"
      // when
      mockMvc.get("/api/banks/$accountNumber")
        .andDo { print() }
        .andExpect {
          status { isNotFound() }
          content {
            this.contentTypeCompatibleWith(MediaType.TEXT_PLAIN)
          }
        }
    }

    @Test
    fun `should return all banks`() {
      mockMvc.get("/api/banks/")
        .andExpect {
          status { isOk() }
          content { contentType(MediaType.APPLICATION_JSON) }
          // NOTE: JsonPath is a query language for json. you can learn it
          jsonPath("$[0].accountNumber", Matchers.equalTo("7856"))
        }
    }
  }

  @Nested
  @DisplayName("POST /api/banks")
  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
  inner class PostBank {
    @Test
    fun `should add a new bank`() {
      // given
      val newBank = Bank("acc123", 31.415, 2)
      // when
      val performPost = mockMvc.post(
        "/api/banks",
        dsl = {
          contentType = MediaType.APPLICATION_JSON
          content = objectMapper.writeValueAsString(newBank)
        },
      )

      performPost
        .andDo { print() }
        .andExpect {
          status { isCreated() }
          jsonPath("$.accountNumber", dsl = { value("acc123") })
          match {
            println("result")
            assertThat(it.response.contentAsString).isEqualTo(objectMapper.writeValueAsString(newBank))
          }
        }
    }

    @Test
    fun `should return bad request if bank with the given account already exists`() {
      // given
      val invalidBank = Bank("1234", 1.0, 2)
      // when
      val performPost = mockMvc.post(
        "/api/banks",
        dsl = {
          contentType = MediaType.APPLICATION_JSON
          content = objectMapper.writeValueAsString(invalidBank)
        },
      )

      performPost
        .andDo { print() }
        .andExpect {
          status { isBadRequest() }
        }
    }
  }

}