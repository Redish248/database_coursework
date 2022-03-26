package itmo.coursework.controller

import itmo.coursework.model.AddNewStaffRequest
import itmo.coursework.model.UpdateStaffRequest
import itmo.coursework.service.StaffServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/databases/staff")
class StaffController(private val staffService: StaffServiceImpl) {

    @GetMapping
    fun getAllStaff() = staffService.getStaff()

    @GetMapping("positions")
    fun getPositions() = staffService.getPositions()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addNewStaffAccount(@RequestBody request: AddNewStaffRequest) = staffService.createNewStaffAccount(request)

    @PutMapping("{staffUid}")
    fun updateStaffAccount(@PathVariable staffUid: Long, @RequestBody request: UpdateStaffRequest) =
        staffService.updateStaffAccount(staffUid, request)

}