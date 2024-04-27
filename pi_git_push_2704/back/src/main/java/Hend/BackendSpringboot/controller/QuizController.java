package Hend.BackendSpringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import Hend.BackendSpringboot.entity.Quiz;
import Hend.BackendSpringboot.service.QuizService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quizzes") // Base path for all quiz-related requests
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    // Get all quizzes
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes(); // Delegate to service method
    }

    // Get a specific quiz by ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Optional<Quiz> getQuizById(@PathVariable Long id) {
        return quizService.getQuizById(id); // Delegate to service method
    }

    @GetMapping("/ByTrainingContent/{trainingContentId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Quiz> getQuizzesByTrainingContentId(@PathVariable Long trainingContentId) {
        return quizService.getQuizzesByTrainingContentId(trainingContentId);
    }

    // Save a new quiz
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.saveQuiz(quiz); // Delegate to service method
    }

    // Update a quiz (replace entire quiz object)
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Quiz updateQuiz(@PathVariable Long id, @RequestBody Quiz updatedQuiz) {
        return quizService.updateQuiz(id, updatedQuiz); // Delegate to service method
    }


    // Endpoint to get the most popular quiz type
    @GetMapping("/statistics/mostPopularQuizType")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getMostPopularQuizType() {
        return quizService.getMostPopularQuizType();
    }

    // Endpoint to get the total number of quizzes
    @GetMapping("/statistics/totalQuizzesCount")
    @PreAuthorize("hasAuthority('ADMIN')")
    public long getTotalQuizzesCount() {
        return quizService.getTotalQuizzesCount();
    }

    // Endpoint to get the average quiz score
    @GetMapping("/statistics/averageQuizScore")
    @PreAuthorize("hasAuthority('ADMIN')")
    public double getAverageQuizScore() {
        return quizService.getAverageQuizScore();
    }




    // Delete a quiz by ID
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Indicate successful deletion without content
    public void deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id); // Delegate to service method
    }

    // Custom exception handler for ResourceNotFoundException (remains the same)
}
