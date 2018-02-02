package com.lxy11.drbox.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxy11.drbox.po.User;
import com.lxy11.drbox.Dao.UserInfoRepository;
import com.lxy11.drbox.utils.ResultMsg;
import com.lxy11.drbox.utils.ResultStatusCode;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserInfoRepository userRepositoy;

    @RequestMapping("getUserInfoById")
    public Object getUser(int id)
    {
        User userEntity = userRepositoy.findUserInfoById(id);
        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), userEntity);
        return resultMsg;
    }

    @RequestMapping("getAllUserInfoByStatus")
    public Object getUserInfoByStatus()
    {
        List<User> userEntity = userRepositoy.nativeQuerry(true);
        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), userEntity);
        return resultMsg;
    }

    @Modifying
    @RequestMapping("adduser")
    public Object addUser(@RequestBody User userEntity)
    {
        userRepositoy.save(userEntity);
        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), userEntity);
        return resultMsg;
    }

    @Modifying
    @RequestMapping("updateuser")
    public Object updateUser(@RequestBody User userEntity)
    {
        User user = userRepositoy.findUserInfoById(userEntity.getId());
        if (user != null)
        {
            user.setName(userEntity.getName());
            userRepositoy.save(user);
        }
        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), null);
        return resultMsg;
    }

    @Modifying
    @RequestMapping("deleteuser")
    public Object deleteUser(int id)
    {
        userRepositoy.delete(id);
        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), null);
        return resultMsg;
    }
}  
