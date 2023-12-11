package Hospital.medic.Controller;

import Hospital.medic.Dto.MemberDTO;
import Hospital.medic.Entity.RecordEntity;
import Hospital.medic.Service.MemberService;
import Hospital.medic.Service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoginController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private RecordService recordService;


    //환자 로그인 및 환자 대쉬보드
    @GetMapping("/")
    public String loginForm(){
        return "login";
    }


    @ResponseBody
    @PostMapping("/member/loginChk")
    public String getLogin(@RequestParam Integer id, String pw, HttpSession session) {
        MemberDTO dto = new MemberDTO();
        dto.setNumber(id);
        dto.setMemberPassword(pw);
        MemberDTO loginResult = memberService.login(dto);
        if (loginResult !=null) {
            //로그인 성공
            session.setAttribute("membername",
                    loginResult.getMemberName());
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
        }
        model.addAttribute("list", recordEntityList);
        return "main";
    }

    //의사 로그인 페이지 대쉬 보드
    @ResponseBody
    @PostMapping("/member/doctorlogin")
    public String getDoctorlogin(@RequestParam Integer id, String pw, HttpSession session) {
        MemberDTO dto = new MemberDTO();
        dto.setNumber(id);
        dto.setMemberPassword(pw);
        MemberDTO loginResult = memberService.login(dto);
        if (loginResult !=null) {
            //로그인 성공
            session.setAttribute("membername",
                    loginResult.getMemberName());
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
    public String DoctorMainTemplate(Model model, HttpSession session) {
        List<RecordEntity> recordEntityList = recordService.recordEntityList(String.valueOf(session.getAttribute("membername")));
        for (RecordEntity entity : recordEntityList) {
        }
        model.addAttribute("list", recordEntityList);
        return "doctordashbord";
    }
    @PostMapping("/search")
    public String searchRecords(@RequestParam(name = "R_name", required = false) String R_name, Model model) {
        if (R_name != null && !R_name.isEmpty()) {
            List<RecordEntity> searchResults = recordService.searchRecordsByName(R_name);
            model.addAttribute("R_name", searchResults);
            System.out.println("R_name =" + R_name);
        } else {
            // 이름이 null 또는 빈 문자열인 경우에 대한 처리
            model.addAttribute("R_name", Collections.emptyList());
        }
        return "doctordashbord";
    }
    //로그아웃 컨트롤러
    @GetMapping("/member/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    @GetMapping("/member/login")
    public String recordlist(Model model){
        return "main";
    }
}
