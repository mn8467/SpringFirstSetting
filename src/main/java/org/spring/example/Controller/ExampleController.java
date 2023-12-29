package org.spring.example.Controller;

import org.spring.example.Service.ExampleVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExampleController {

    @RequestMapping(value = "/example.do", method = RequestMethod.GET)
    public String ExampleMain() {
        return "example";
    }

    @RequestMapping(value = "/exampleList.do", method = RequestMethod.GET)
    public String exampleList(Model model) throws Exception {

        // 포맷터
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        List<ExampleVO> exampleList = new ArrayList<>();
        ExampleVO exampleVO = null;

        exampleVO = new ExampleVO(
                1
                , "captain"
                , "캡틴 아메리카"
                , "First Avenger"
                , null
                , formatter.parse("2011-07-28")
        );
        exampleList.add(exampleVO);

        exampleVO = new ExampleVO(
                2
                , "ironman"
                , "아이언 맨"
                , "I Am Iron Man"
                , null
                , formatter.parse("2008-04-30")
        );
        exampleList.add(exampleVO);

        exampleVO = new ExampleVO(
                3
                , "thor"
                , "토르"
                , "God of Thunder"
                , null
                , formatter.parse("2011-04-28")
        );
        exampleList.add(exampleVO);

        model.addAttribute("exampleTitle", "영화 타이틀");
        model.addAttribute("exampleList", exampleList);

        return "exampleList";
    }

    @RequestMapping(value = "/exampleInfo.do", method = RequestMethod.GET)
    public String exampleInfo(HttpServletRequest request, Model model) throws Exception {

        if (request.getParameter("number").isEmpty() == false) {

            if (request.getParameter("number").equals("1") == true) {
                model.addAttribute("exampleId", "captain");
                model.addAttribute("exampleName", "캡틴 아메리카");
                model.addAttribute("exampleTitle", "First Avenger");
                model.addAttribute("exampleInfo",
                        "캡틴 아메리카의 '캡틴'은 초창기 코믹스에서는 말 그대로 미국의 대장이라는 뉘앙스로 쓰였으나,"
                                + "<br/>시간이 흘러 캡틴이라는 말에는 어벤져스의 넘버 원이라는 의미도 포함되었다."
                );
                model.addAttribute("exampleDate", "2011-07-28");
            }

            if (request.getParameter("number").equals("2") == true) {
                model.addAttribute("exampleId", "ironman");
                model.addAttribute("exampleName", "아이언 맨");
                model.addAttribute("exampleTitle", "I Am Iron Man");
                model.addAttribute("exampleInfo",
                        "억만장자 천재 발명가인 토니 스타크가 심장에 치명적인 상처를 입은 자신의 목숨을 지키며"
                                + "<br/>동시에 세계를 지킬 강화 슈트를 제작하고 과학의 결정체로 만들어진 슈트를 입고"
                                + "<br/>아이언맨이 되어 범죄와 싸워나간다."
                );
                model.addAttribute("exampleDate", "2008-04-30");
            }

            if (request.getParameter("number").equals("3") == true) {
                model.addAttribute("exampleId", "thor");
                model.addAttribute("exampleName", "토르");
                model.addAttribute("exampleTitle", "God of Thunder");
                model.addAttribute("exampleInfo",
                        "아스가르드의 주신 오딘은 아들 토르에게 인간성과 겸손함을 배우게 하기 위해 기억을 지우고"
                                + "<br/>절름발이 의사 도널드 블레이크의 육신에 토르를 내려보냈다."
                );
                model.addAttribute("exampleDate", "2011-04-28");
            }
        }

        return "exampleInfo";
    }
}
