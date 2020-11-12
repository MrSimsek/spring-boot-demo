package com.makercode.springbootdemo.course;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {
    private List<Course> courses = new ArrayList<>(
            Arrays.asList(
                    new Course("spring", "Spring Framework", "Description about Spring Framework"),
                    new Course("javascript", "JavaScript Language", "Description about JavaScript")
            )
    );

    public List<Course> getCourses() {
        return courses;
    }

    public Course getCourse(String courseId) {
        return courses.stream().filter(course -> course.getId().equals(courseId)).findFirst().get();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void updateTopic(String topicId, Course courseUpdated) {
        Course course = courses.stream().filter(t -> t.getId().equals(topicId)).findFirst().get();
        courses.set(courses.indexOf(course), courseUpdated);
    }

    public void deleteCourse(String courseId) {
        courses.removeIf(course -> course.getId().equals(courseId));
    }
}
