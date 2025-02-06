package com.myselectshop.controller;

import com.myselectshop.dto.SignupRequestDto;
import com.myselectshop.dto.UserInfoDto;
import com.myselectshop.entity.UserRoleEnum;
import com.myselectshop.security.UserDetailsImpl;
import com.myselectshop.service.FolderService;
import com.myselectshop.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final FolderService folderService;

    /**
     * 로그인 페이지를 반환하는 메서드
     * @return : 로그인 페이지 html명 반환
     */
    @GetMapping("/user/login-page")
    public String loginPage() {
        return "login";
    }

    /**
     * 회원가입 페이지를 반환하는 메서드
     * @return : 회원가입 페이지 html명 반환
     */
    @GetMapping("/user/signup")
    public String signupPage() {
        return "signup";
    }

    /**
     * 회원가입 메서드
     * @param requestDto : 회원가입을 진행하려는 사용자의 정보
     * @param bindingResult : valication 오류 확인
     * @return : redirect할 url (성공하면 로그인, 실패한 회원가입 페이지)
     */
    @PostMapping("/user/signup")
    public String signup(@Valid SignupRequestDto requestDto, BindingResult bindingResult) {
        // Validation 예외처리
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if(fieldErrors.size() > 0) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                log.error(fieldError.getField() + " 필드 : " + fieldError.getDefaultMessage());
            }
            return "redirect:/api/user/signup";
        }

        userService.signup(requestDto);

        return "redirect:/api/user/login-page";
    }
    
    /**
     * 회원의 정보를 가져오는 메서드
     * @param userDetails : 현재 로그인한 사용자의 정보
     * @return : 사용자의 관리자 여부를 포함한 정보 반환
     */
    @GetMapping("/user-info")
    @ResponseBody
    public UserInfoDto getUserInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        String username = userDetails.getUser().getUsername();
        UserRoleEnum role = userDetails.getUser().getRole();
        boolean isAdmin = (role == UserRoleEnum.ADMIN);

        return new UserInfoDto(username, isAdmin);
    }

    /**
     * 사용자가 생성한 폴더들을 가져오는 메서드
     * @param model : 데이터를 담을 model
     * @param userDetails : 현재 로그인한 사용자
     * @return : 정보를 담아 반환할 페이지
     */
    @GetMapping("/user-folder")
    public String getUserInfo(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("folders", folderService.getFolders(userDetails.getUser()));
        return "index :: #fragment";
    }
}
