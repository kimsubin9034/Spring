package com.codingbox.Springtest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.codingbox.Springtest.repository.StudentRepository;
import com.codingbox.Springtest.student.Student;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/basic/students")
@RequiredArgsConstructor
public class BasicStudentController {

    private final StudentRepository studentRepository = new StudentRepository();

    @GetMapping
    public String students(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "basic/students";
    }

    @GetMapping("/{studentId}")
    public String student(@PathVariable long studentId, Model model) {
        Student student = studentRepository.findByNum(studentId);
        model.addAttribute("student", student);
        return "basic/student";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("student", new Student());
        return "basic/studentAddForm";
    }

    @PostMapping("/add")
    public String saveStudent(@ModelAttribute Student student, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!StringUtils.hasText(student.getStudentName())) {
            bindingResult.addError(new FieldError("student", "studentName", "학생명은 필수입니다."));
        }

        if (bindingResult.hasErrors()) {
            return "basic/studentAddForm";
        }

        studentRepository.save(student);
        redirectAttributes.addFlashAttribute("status", true);
        return "redirect:/basic/students";
    }

    @GetMapping("/{studentId}/edit")
    public String editForm(@PathVariable long studentId, Model model) {
        Student student = studentRepository.findByNum(studentId);
        model.addAttribute("student", student);
        return "basic/studentEditForm";
    }

    @PostMapping("/{studentId}/edit")
    public String edit(@PathVariable long studentId, @ModelAttribute Student student) {
        
    	
    	studentRepository.update(studentId, student);
        return "redirect:/basic/students/{studentId}";
    }

    // 테스트 데이터 추가
    @PostConstruct
    public void init() {
        studentRepository.save(new Student());
        studentRepository.save(new Student());
    }
}
