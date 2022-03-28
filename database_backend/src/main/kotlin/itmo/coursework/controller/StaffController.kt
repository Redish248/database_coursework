package itmo.coursework.controller

import itmo.coursework.model.AddStaffAccountRequest
import itmo.coursework.model.UpdateStaffRequest
import itmo.coursework.service.StaffServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/databases/staff")
class StaffController(private val staffService: StaffServiceImpl) {

    @GetMapping
    fun getAllStaff(user: Principal) = staffService.getStaff(user)

    @GetMapping("positions")
    fun getPositions() = staffService.getPositions()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addNewStaffAccount(@RequestBody request: AddStaffAccountRequest) = staffService.createNewStaffAccount(request)

    @PutMapping("{staffUid}")
    fun updateStaffAccount(@PathVariable staffUid: Long, @RequestBody request: UpdateStaffRequest) =
        staffService.updateStaffAccount(staffUid, request)

    @DeleteMapping("{staffUid}")
    fun deleteStaffAccount(@PathVariable staffUid: Long) = staffService.deleteStaffAccount(staffUid)
}