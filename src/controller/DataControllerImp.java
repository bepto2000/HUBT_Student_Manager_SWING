package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import controller_sapXep.SortRegisteringByRegisterTimeASC;
import controller_sapXep.SortRegisteringByRegisterTimeDESC;
import controller_sapXep.SortRegisteringByStudentNameASC;
import controller_sapXep.SortRegisteringByStudentNameDESC;
import controller_sapXep.SortStudentByIdASC;
import controller_sapXep.SortStudentByNameASC;
import controller_sapXep.SortStudentByNameDESC;
import controller_sapXep.SortSubjectByNameASC;
import controller_sapXep.SortSubjectByNameDESC;
import controller_sapXep.SortSubjectByNumOfLessonASC;
import controller_sapXep.SortSubjectByNumOfLessonDESC;
import Class.Course;
import Class.Registering;
import Class.Student;
import Class.Subject;


public class DataControllerImp implements DataController {

    @Override
    public <T> void writeToFile(List<T> data, String fileName) {
        try ( FileOutputStream fos = new FileOutputStream(fileName);  
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(data);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public <T> List<T> readDataFromFile(String fileName) {
        List<T> data = new ArrayList<>();
        File file = new File(fileName);
        if (file.length() > 0) {
            try ( FileInputStream fis = new FileInputStream(fileName);  
                    ObjectInputStream ois = new ObjectInputStream(fis)) {
                data = (List<T>) ois.readObject();
            } catch (FileNotFoundException | ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return data;
    }

    @Override
    public void updateSubjectId(List<Subject> subjects) {
        if (subjects != null && subjects.size() > 0) {
            int maxId = subjects.get(0).getId();
            for (int i = 1; i < subjects.size(); i++) {
                int id = subjects.get(i).getId();
                if (id > maxId) {
                    maxId = id;
                }
            }
            Subject.setSid(maxId + 1);
        }
    }

    @Override
    public void sortSubjectByNameASC(List<Subject> subjects) {
        subjects.sort(new SortSubjectByNameASC());
    }

    @Override
    public void sortSubjectByNameDESC(List<Subject> subjects) {
        subjects.sort(new SortSubjectByNameDESC());
    }

    @Override
    public void sortSubjectByNumOfLessonASC(List<Subject> subjects) {
        subjects.sort(new SortSubjectByNumOfLessonASC());
    }

    @Override
    public void sortSubjectByNumOfLessonDESC(List<Subject> subjects) {
        subjects.sort(new SortSubjectByNumOfLessonDESC());
    }

    @Override
    public List<Subject> searchSubjectByName(
            List<Subject> subjects, String key) {
        var regex = ".*" + key + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        List<Subject> result = new ArrayList<>();
        for (var e : subjects) {
            Matcher matcher = pattern.matcher(e.getName());
            if (matcher.matches()) {
                result.add(e);
            }
        }
        return result;
    }

    /**
     * Tìm môn học theo số tiết học. Có 3 khả năng xảy ra: 1. Tìm từ from trở
     * lên 2. Tìm từ to trở xuống 3. tìm từ from đến to
     *
     * @param subjects danh sách môn học cần thao tác
     * @param from giá trị giới hạn dưới của số tiết
     * @param to giá trị giới hạn trên của số tiết
     * @return trả về danh sách khóa học thỏa mãn
     */
    @Override
    public List<Subject> searchSubjectByNumOfLesson(List<Subject> subjects,
            int from, int to) {
        List<Subject> result = new ArrayList<>();
        if (from == -1) {
            for (var e : subjects) {
                if (e.getNumOfLesson() <= to) {
                    result.add(e);
                }
            }
        } else if (to == -1) {
            for (var e : subjects) {
                if (e.getNumOfLesson() >= from) {
                    result.add(e);
                }
            }
        } else {
            for (var e : subjects) {
                if (e.getNumOfLesson() >= from && e.getNumOfLesson() <= to) {
                    result.add(e);
                }
            }
        }
        return result;
    }

    @Override
    public List<Student> searchStudentByName(
            List<Student> students, String name) {
        List<Student> result = new ArrayList<>();
        var regex = ".*" + name + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        for (Student student : students) {
            var fullName = student.getFullName();
            Matcher matcher = pattern.matcher(fullName);
            if (matcher.matches()) {
                result.add(student);
            }
        }
        return result;
    }

    @Override
    public List<Student> searchStudentById(List<Student> students, String id) {
        List<Student> result = new ArrayList<>();
        var regex = ".*" + id + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        for (Student student : students) {
            var studentId = student.getStudentId();
            Matcher matcher = pattern.matcher(studentId);
            if (matcher.matches()) {
                result.add(student);
            }
        }
        return result;
    }

    @Override
    public List<Student> searchStudentByMajor(
            List<Student> students, String major) {
        List<Student> result = new ArrayList<>();
        var regex = ".*" + major + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        for (Student student : students) {
            var studentMajor = student.getMajor();
            Matcher matcher = pattern.matcher(studentMajor);
            if (matcher.matches()) {
                result.add(student);
            }
        }
        return result;
    }

    @Override
    public void sortStudentByIdASC(List<Student> students) {
        students.sort(new SortStudentByIdASC());
    }

    @Override
    public void sortStudentByNameASC(List<Student> students) {
        students.sort(new SortStudentByNameASC());
    }

    @Override
    public void sortStudentByNameDESC(List<Student> students) {
        students.sort(new SortStudentByNameDESC());
    }

    @Override
    public void sortRegisteringByStudentNameAZ(List<Registering> registerings) {
        registerings.sort(new SortRegisteringByStudentNameASC());
    }

    @Override
    public void sortRegisteringByStudentNameZA(List<Registering> registerings) {
        registerings.sort(new SortRegisteringByStudentNameDESC());
    }

    @Override
    public void sortRegisteringByRegisterTimeEL(List<Registering> registerings) {
        registerings.sort(new SortRegisteringByRegisterTimeASC());
    }

    @Override
    public void sortRegisteringByRegisterTimeLE(List<Registering> registerings) {
        registerings.sort(new SortRegisteringByRegisterTimeDESC());
    }

    @Override
    public List<Registering> searchRegisteringByStudentName(List<Registering> rs,
            String key) {
        List<Registering> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(".*" + key + ".*",
                Pattern.CASE_INSENSITIVE);
        for (Registering r : rs) {
            Matcher matcher = pattern.matcher(r.getStudent().getFirstName());
            if (matcher.matches()) {
                result.add(r);
            }
        }
        return result;
    }

    @Override
    public List<Registering> searchRegisteringByRegisterTime(
            List<Registering> rs, Date fromDate, Date toDate) {
        List<Registering> result = new ArrayList<>();
        for (Registering r : rs) {
            if (fromDate.getTime() <= r.getRegistedTime().getTime()
                    && (toDate.getTime() + 24 * 60 * 60 * 1000 - 1)
                    >= r.getRegistedTime().getTime()) {
                result.add(r);
            }
        }
        return result;
    }

    /**
     * Phương thức dùng để xếp lớp cho sinh viên. Điều kiện là danh sách đăng ký
     * đã sắp xếp theo thứ tự đăng ký từ sớm nhất đến muộn nhất.
     *
     * @param rs danh sách đăng ký
     * @return danh sách lớp sinh viên đã phân lớp học phần
     */
    @Override
    public List<Course> createCouse(List<Registering> rs,
            List<Subject> subjects) {
        var letters = "ABCDEFGHIJKLMNOPQRSTXYZ";
        var startIndex = 0;
        List<Course> courses = new ArrayList<>();
        for (var s : subjects) {
            Course course = new Course();
            course.setName(s.getName() + "_" + letters.charAt(startIndex++));
            courses.add(course);
            for (var r : rs) {
                if (r.getSubject().getName().compareTo(s.getName()) == 0) {
                    // Nếu danh sách lớp chưa đủ 50 sv, thêm bản đăng ký 
                    // hiện tại vào ds, ngược lại, tạo lớp học mới
                    if (course.getRegisterings().size() >= 50) {
                        course = new Course();
                        course.setName(s.getName()
                                + "_" + letters.charAt(startIndex++));
                        courses.add(course);
                    }
                    course.addToCourse(r);
                }
            }
            startIndex = 0; // bắt đầu đánh số cho lớp học phần khác
        }
        return courses;
    }
}
