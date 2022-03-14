package itmo.coursework.controller

import itmo.coursework.model.AddNewStaffRequest
import itmo.coursework.service.StaffServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController("databases/staff")
class StaffController(private val staffService: StaffServiceImpl) {

    @GetMapping
    fun getAllStaff() = staffService.getStaffBySalaryGreaterThan(0)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addNewStaff(@RequestBody request: AddNewStaffRequest) = staffService.createNewStaffAccount(request)
}