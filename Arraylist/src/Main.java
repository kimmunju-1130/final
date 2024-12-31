import java.util.ArrayList;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Subject {
    private String subjects; //과목
    private int grade; //점수

    Subject (String subjects, int grade) {
        this.subjects = subjects;
        this.grade = grade;
    }

    public String getSubject() {return subjects;}
    public int getGrade() {return grade;}

    public void setSbject() {this.subjects = subjects;}
    public void setGrade() {this.grade = grade;}
    public String toString() { return "과목 : " + subjects + " 점수 : " + grade; }
}



class Student {
    private String name;
    private int age;
    private int number;
    private ArrayList<Subject> subjects;
    private String St_pw;

    Student (String name, int age, int number, ArrayList<Subject> subjects, String St_pw ) {
        this.name = name;
        this.age = age;
        this.number = number;
        this.subjects = subjects;
        this.St_pw = St_pw;
    }

    public String getName() {return name;}
    public int getAge() {return age;}
    public int getNumber() {return number;}
    public ArrayList<Subject> getSubjects() {return subjects;}
    public String getStpw() {return St_pw;}

    public void setName(String name){this.name = name;}
    public void setAge(int age){this.age = age;}
    public void setNumber(int number){this.number = number;}
    public void setSubjects(ArrayList<Subject> subject){this.subjects = subject;}
    public void setStpw(String St_pw) {this.St_pw = St_pw;}

    public String toString() { // 형변환
        /*String aa = "";
         for(Subject a : subjects ){
             aa += a.toString();
         }*/

         return "이름 : " + name +" " +"나이 : " + age +" " +"학번 : " + number + " "+ subjects;
    }

}

class professor {
    private String pf_name;
    private String pf_major;
    private int pf_number;
    private String pf_pw;

    professor(String pf_name, String pf_major, int pf_number,String pf_pw){
        this.pf_name = pf_name;
        this.pf_major = pf_major;
        this.pf_number = pf_number;
        this.pf_pw = pf_pw;
    }

    public String getNamepf() { return pf_name;}
    public String getMajorpf() { return pf_major;}
    public int getNumberpf() { return pf_number;}
    public String getPfpw() { return pf_pw;}

    public void setNamepf(String pf_name) { this.pf_name = pf_name;}
    public void setMajorpf(String pf_major) { this.pf_major = pf_major;}
    public void setNumberpf(int pf_number) { this.pf_number = pf_number;}
    public void setPfpw(String pf_pw) { this.pf_pw = pf_pw;}
}


public class Main {
    public static void main(String[] args) {
        ArrayList<Student> StudentArray = new ArrayList<>();
        ArrayList<professor> professorArray = new ArrayList<>();
        ArrayList<Subject> SubjectArray = new ArrayList<>();
        SubjectArray.add(new Subject("코딩",10));
        professor professorA = new professor("허호범","코딩", 1234,"4321");
        Student StudentA = new Student("김문주",28,12345, SubjectArray,"0987");//어레이리스트로 넣어야함
        StudentArray.add(StudentA);
        professorArray.add(professorA);
        System.out.println("아이디와 비밀번호를 입력하시오.");
        Scanner sc = new Scanner(System.in);
        Scanner scc = new Scanner(System.in); //이름
        Scanner scc2 = new Scanner(System.in); //나이
        Scanner scc3 = new Scanner(System.in); //학번
        int id = sc.nextInt();
        sc.nextLine();
        String pw = sc.nextLine();
        boolean pf_state = false;
        boolean st_state = false;
        System.out.println(id);
        System.out.println(pw);

        for(Student s : StudentArray )
            if(id == s.getNumber()) {
                if(pw.equals(s.getStpw())) {
                    System.out.println("로그인이 되었습니다.");
                    st_state = true;
                }
                else {
                    System.out.println("아이디와 비밀번호가 틀렸습니다.");
                }
            }
        for(professor p : professorArray)
            if(id == p.getNumberpf()) {
                if(pw.equals(p.getPfpw())) {
                    System.out.println("로그인이 되었습니다.");
                    pf_state = true;
                }
                else {
                    System.out.println("아이디와 비밀번호가 틀렸습니다.");
                }
            }

        if(pf_state) {
            while (true) {
                System.out.println("숫자를 입력하시오.");
                System.out.println("1. 학생추가");//스캔받아서 추가 하고
                System.out.println("2. 학생삭제");
                System.out.println("3. 학생조회"); //학번을 누르면 이름, 나이 조회
                System.out.println("4.전체 학생 조회");
                System.out.println("5. 학생 변경");
                System.out.println("6. 성적 입력");
                int ssc = sc.nextInt();

                if (ssc == 1) {
                    System.out.println("이름을 입력해주세요");
                    System.out.println("나이를 입력해주세요");
                    System.out.println("학번을 입력해주세요");
                    System.out.println("비밀번호를 입력해주세요");
                    String nam = scc.nextLine();
                    int ag = scc2.nextInt();
                    int numb = scc3.nextInt();
                    String sp = scc.nextLine();
                    Student A = new Student(nam, ag, numb, null, sp);
                    StudentArray.add(A);
                    //System.out.println(StudentArray.size());
                    //System.out.println(StudentArray.get(0));
                    //System.out.printf("[%s]\t",StudentArray.get(0));
                } else if (ssc == 2) {//학생 삭제
                    System.out.println("삭제할 학번을 입력하시오.");
                    int numb = scc3.nextInt();
                    for (int i = 0; i < StudentArray.size(); i++) {
                        if (StudentArray.get(i).getNumber() == numb) {
                            StudentArray.remove(i);
                            System.out.println("삭제되었습니다.");
                        }
                    }

                } else if (ssc == 3) { //학번을 누르면 이름, 나이 조회
                    for (Student s : StudentArray) {
                        System.out.println("이름, 나이를 조회할 학번을 입력하시오.");
                        int numb = scc3.nextInt();
                        if (s.getNumber() == numb) {
                            System.out.println(s);
                        } else {
                            System.out.println("해당 학번의 학생이 없습니다.");
                        }
                    }

                } else if (ssc == 4) {//전체학생 조회
                    if (StudentArray.isEmpty()) { // .isEmtpy() 비어있으면 true, 하나라도 값이 있으면 false 반환
                        System.out.println("학생이 없습니다.");
                    } else {
                        for (Student s : StudentArray) {
                            System.out.println(s.getName());
                        }
                    }
                } else if (ssc == 5) { //학생 변경
                    System.out.println("변경할 학번을 입력하시오.");
                    int numb = scc3.nextInt();
                    for (Student s : StudentArray) {
                        if (s.getNumber() == numb) {
                            System.out.println("변경할 이름을 입력하시오");
                            String name = sc.nextLine();
                            System.out.println("변경할 나이를 입력하시오");
                            int age = sc.nextInt();
                            s.setName(name);
                            s.setAge(age);
                        }
                    }
                } else if (ssc == 6) {
                    System.out.println("성적을 입력할 학번을 입력하시오.");
                    int numb = scc3.nextInt();
                    for (Student s : StudentArray) {
                        if (s.getNumber() == numb) {
                            System.out.println("성적을 입력하시오.");
                            int scgrade = scc3.nextInt();
                            Subject A = new Subject("컴퓨터", scgrade);
                            if (s.getSubjects() == null) {
                                s.setSubjects(new ArrayList<>());
                            }
                            s.getSubjects().add(A);
                        }
                    }

                }
            }
        }
       else if(st_state){
           while(true){
               System.out.println("숫자를 입력하시오.");
               System.out.println("1. 성적 조회");
               System.out.println("2. 비밀번호 변경");
               System.out.println("3. 휴학신청");
               int st_menu = sc.nextInt();

               if(st_menu==1) {
                   System.out.println("조회할 학번을 입력하시오.");
                   int numb = scc3.nextInt();
                   for(Student s : StudentArray) {
                       if(s.getNumber() == numb) {
                           s.getSubjects();
                           System.out.println(s.getSubjects());
                       }
                       else{
                           System.out.println("해당 학번이 없습니다.");
                       }
                   }
               }
               if(st_menu==2) { //비밀번호 변경
                   for (Student s : StudentArray) {
                       if (s.getNumber() == id) {
                           System.out.println("변경할 비밀번호를 입력하시오");
                           sc.nextLine();
                           String changepw = sc.nextLine();
                           s.setStpw(changepw);
                           System.out.println(changepw);

                           System.out.println("비밀번호가 " + s.getStpw() +" (으)로 변경되었습니다.");
                       }
                   }

               }
               if(st_menu==3) { //휴학신청

               }

           }
        }




    }
}