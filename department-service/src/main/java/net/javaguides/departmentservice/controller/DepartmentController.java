package net.javaguides.departmentservice.controller;


import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    //Build save department Rest API

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment( @RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return  new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }


    // Build Get department REST API

    @GetMapping("{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartment( @PathVariable  String departmentCode){

        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);

        return  new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}


