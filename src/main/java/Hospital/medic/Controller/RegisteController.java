package Hospital.medic.Controller;

import Hospital.medic.Dto.MemberDTO;
import Hospital.medic.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Member;

@Controller
@RequiredArgsConstructor
public class RegisteController {
    //생성자 주입
    private final MemberService memberService;

    @GetMapping("/register/save")
    public String save(){
        return "registe";
    }

    @PostMapping("/register/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("RegisterController.save");
        System.out.println("memberDTO =" + memberDTO);
        memberService.save(memberDTO);
        return "login";
    }

}
