package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.User;
import com.company.project.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/02/16.
*/
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * Request example
     * POST https://aqueous-temple-17765.herokuapp.com/user/add
     * {
     *   "id":121,
     *   "userName":"yyc1",
     *   "password":"yycPassword1",
     *   "nickName":"yycNickName1",
     *   "sex":1,
     *   "registerDate":1518834150733
     * }
     * @param user
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody User user) {
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * Request example
     * POST http://localhost:8080/user/delete?id=1
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * Request example
     * POST http://localhost:8080/user/update
     * {
     *   "id":12,
     *   "userName":"yyc12-2",
     *   "password":"yycPassword12-2",
     *   "nickName":"yycNickName12-2",
     *   "sex":1,
     *   "registerDate":1518834150735
     * }
     * @param user
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * Request example:
     *  POST http://localhost:8080/user/detail?id=1
     * @param id
     * @return
     */
    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        User user = userService.findById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    /**
     * Request example:
     *  POST
     *  http://localhost:8080/user/list
     *  {
     *    "page":1,
     *    "size":10
     *  }
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
