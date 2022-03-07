package itmo.coursework

import itmo.coursework.exception.StaffNotFoundException
import itmo.coursework.service.StaffServiceImpl
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class StaffTest {

    @Autowired
    private lateinit var staffServiceImpl: StaffServiceImpl

    @Test
    fun `get unknown staff by uid`() {
        val thrown = assertThrows(StaffNotFoundException::class.java) {
            staffServiceImpl.getStaffByUid(666)
        }
        assertEquals("Staff with uid 666 not found", thrown.message)
    }

}