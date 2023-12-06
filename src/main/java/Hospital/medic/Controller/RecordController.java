package Hospital.medic.Controller;

import Hospital.medic.Entity.RecordEntity;
import Hospital.medic.Service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping("/record/detail")
    public String detail(Model model, Integer R_id) {
        model.addAttribute("detail", recordService.record_detail(R_id));

        System.out.println(recordService.record_detail(R_id).toString());



        return "record_detail";


    }








}
