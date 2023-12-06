package Hospital.medic.Controller;

import Hospital.medic.Dto.MemberDTO;
import Hospital.medic.Entity.RecordEntity;
import Hospital.medic.Service.MemberService;
import Hospital.medic.Service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoginController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private RecordService recordService;

    @GetMapping("/")
    public String loginForm(){
        return "login";
    }


    @ResponseBody
    @PostMapping("/member/loginChk")
    public String getLogin(@RequestParam Integer id, String pw, HttpSession session) {
        System.out.println(id);

        MemberDTO dto = new MemberDTO();
        dto.setNumber(id);
        dto.setMemberPassword(pw);

        MemberDTO loginResult = memberService.login(dto);
        if (loginResult !=null) {
            //로그인 성공
            session.setAttribute("membername",
                    loginResult.getMemberName());
            System.out.println(loginResult);

            return "success";




        } else {
            //로그인 실패


            return "Fail";
        }

    }

    @GetMapping("/member/main")
    public String MemberMainTemplate(Model model,HttpSession session) {
        System.out.println("Access MemberMainTemplate");
        List<RecordEntity> recordEntityList = recordService.recordEntityList(String.valueOf(session.getAttribute("membername")));

        for (RecordEntity entity : recordEntityList) {
            System.out.println(entity);
        }
        System.out.println("접근");


        System.out.println(session);
        model.addAttribute("list", recordEntityList);




        return "main";
    }

    //의사 로그인 페이지
    @ResponseBody
    @PostMapping("/member/doctorlogin")
    public String getDoctorlogin(@RequestParam Integer id, String pw, HttpSession session) {
        System.out.println(id);

        MemberDTO dto = new MemberDTO();
        dto.setNumber(id);
        dto.setMemberPassword(pw);

        MemberDTO loginResult = memberService.login(dto);
        if (loginResult !=null) {
            //로그인 성공
            session.setAttribute("membername",
                    loginResult.getMemberName());
            System.out.println(loginResult);

            return "success";




        } else {
            //로그인 실패


            return "Fail";
        }

    }

    @GetMapping("/doctor")
    public String doctorloginForm(){
        return "doctorlogin";
    }



    @GetMapping("/doctor/main")
    public String DoctorMainTemplate(Model model,HttpSession session) {
        System.out.println("Access DoctorMainTemplate");
        List<RecordEntity> recordEntityList = recordService.recordEntityList(String.valueOf(session.getAttribute("membername")));

        for (RecordEntity entity : recordEntityList) {
            System.out.println(entity);
        }
        System.out.println("접근");


        System.out.println(session);
        model.addAttribute("list", recordEntityList);




        return "doctordashbord";
    }




    @GetMapping("/member/login")
    public String recordlist(Model model){

//        model.addAttribute("list", recordService.recordEntityList());

        return "main";
    }














    //================================ 테스트용
    @GetMapping("/test")
    public String test(){
        return "main";
    }
}
