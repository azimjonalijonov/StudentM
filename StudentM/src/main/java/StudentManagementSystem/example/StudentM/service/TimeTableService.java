package StudentManagementSystem.example.StudentM.service;

import StudentManagementSystem.example.StudentM.entity.TimeTable;
import StudentManagementSystem.example.StudentM.repo.TimeTableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeTableService  {
    @Autowired
    TimeTableRepo timeTableRepo;
    public TimeTable save(TimeTable timeTable){
        return timeTableRepo.save(timeTable);

    }
    public List<TimeTable> findByYear(Long year){
        return timeTableRepo.findByYear(year);
    }
}
