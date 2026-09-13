package com.vishal.student_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return """
            <!DOCTYPE html>
            <html>
            <head><meta charset="UTF-8"><title>Student Management System API</title>
            <style>
                body { font-family: system-ui, sans-serif; max-width: 700px; margin: 60px auto; padding: 0 20px; color: #1a1a1a; }
                h1 { color: #2c3e50; }
                .endpoint { background: #f5f5f5; padding: 12px 16px; margin: 8px 0; border-radius: 6px; border-left: 4px solid #3498db; }
                .method { font-weight: bold; color: #2980b9; min-width: 60px; display: inline-block; }
                code { background: #e8e8e8; padding: 2px 6px; border-radius: 3px; }
                p { color: #555; }
            </style>
            </head>
            <body>
                <h1>🎓 Student Management System API</h1>
                <p>Spring Boot REST API — running and connected to MySQL.</p>
                <h2>Student Endpoints</h2>
                <div class="endpoint"><span class="method">GET</span> <code>/students</code> — List all students</div>
                <div class="endpoint"><span class="method">POST</span> <code>/students</code> — Create a student</div>
                <div class="endpoint"><span class="method">GET</span> <code>/students/{id}</code> — Get student by ID</div>
                <div class="endpoint"><span class="method">PUT</span> <code>/students/{id}</code> — Update a student</div>
                <div class="endpoint"><span class="method">DELETE</span> <code>/students/{id}</code> — Delete a student</div>
                <h2>Other Endpoints</h2>
                <div class="endpoint"><span class="method">GET</span> <code>/courses</code> — Course endpoints</div>
                <div class="endpoint"><span class="method">GET</span> <code>/teachers</code> — Teacher endpoints</div>
                <p style="margin-top:30px;font-size:0.85em;color:#999;">Try: <code>curl http://localhost:3000/students</code></p>
            </body>
            </html>
            """;
    }
}
