package in.studentmanagement.myproject.controller;

import in.studentmanagement.myproject.model.Student;
import in.studentmanagement.myproject.repository.Studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Studentcontroller {

    @Autowired
Studentrepository studentrepository;

    @GetMapping("/listofstudents")
    public List<Student> getAllStudent(){return studentrepository.findAll();}

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable Integer id){return studentrepository.findById(id).get();}

    @PostMapping("/student")
    public String addStudent(@RequestBody Student student){
       boolean studentexistance = studentrepository.existsById(student.getId());
       if(!studentexistance)
       {
           studentrepository.save(student);
           return " Student Save Successfully";
       }
       else {
           return "Student already exist";
       }
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable Integer id){
        boolean studentexistance = studentrepository.existsById(id);
        if(studentexistance) {
            studentrepository.deleteById(id);
            return "Student deleted successfully";
        }
            else {
                return "Student does not exist";
            }
    }
    @PutMapping("/student/{id}")
        public String updateStudent(@RequestBody Student student, @PathVariable Integer id){
        Student studentobj = studentrepository.findById(id).get();
        studentobj.setName(student.getName());
        studentobj.setAddress(student.getAddress());
        studentrepository.save(studentobj);
        return "Record is Updated ";
        }


}
