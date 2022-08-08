package shadow.user.service;

import org.springframework.dao.DataAccessException;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import common.collection.ABox;
import common.collection.ABoxList;

/**
 * <pre>
 * 	라운지 서비스 인터페이스 정의
 * </pre>
 */
public interface UserService {
	
	
	@Override
	public ABox addUser(ABox userBox) {
		ABox resultBox = new ABox();
		try {
			ABox abox = userBox;
			
			if (userBox.getString("userName").length() > 5 && userBox.getString("userPassword").length() > 5
					&& userBox.getString("userNickName").length() > 5) {
				
				if (commonDao.insert("mybatis.common.common_mapper.insertUserSQL", aBox) !=0) {
					
					resultBox.set("result", "ok");
				} else {
					result.set("result", "fail");
					
				}
		} else {
			resultBox.set("result", "fail");
		}
	} catch (Exception ex) {
	    resultBox.set("result", "fail"));
		ex.printStackTrace();
		}
		return resultBox;
	}
	
	
	
	@Override
	public ABox loginUser(ABox userBox) {
		ABox resultBox = new ABox();
		try {
			ABox userBox = new ABox();
			
			//검증이 성공했는가를 표현하고 싶은데,, 어떻게 하면 좋을까요,,,,
			if(userBox.getString("userName") && userBox.getString("userPassword)) {
				
			  resultBox.set("result", "ok");	
			} else {
				result.set("result", "fail")
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			resultBox.set("result", "fail");
		}
		return resultBox;
	}
		
		
		
		
		
		
	@Override
	public ABox modifyprofile(ABox userBox) {
		ABox resultBox = new ABox();
		try {
			//프로필 수정 정보 입력
			
			if (commonDao.update("mybatis.common.common_mapper.updateUserSQL", aBox) !=0) {
				
				resultBox.set("result", "ok");
			} else {
				
				resultBox.set("result", "fail");
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			resultBox.set("result", "fail");
		}
		return resultBox;
	}

	@Override
	public ABox selectprofile(ABox userBox) {
		ABox resultBox = new ABox();
		try {
			// 프로필 정보
			// 프로필 정보 조회가 잘 되는가
			if (commonDao.select("mybatis.common.common_mapper.selectUserSQL", aBox) !=0)
			
			resultBox.set("check", "ok");

		} catch (Exception ex) {
			ex.printStackTrace();
			resultBox.set("check", "fail");
		}
		return resultBox;
	}

	@Override
	public ABox wishgoods(ABox paramBox) {
		ABox resultBox = new ABox();
		try {
			//유저, 상품 정보
			userList = commonDao.selectList("mybatis.user.user_mapper.selectuserListSQL", aBox);
			goodsList = commonDao.selectList("mybatis.goods.goods_mapper.selectGoodsListSQL", paramBox);
			//tb_user_wish 조회
			//데이터가 존재하는가?
			if()
			//tb_user_wish 생성
			//user_wish 상태 코드 및 성공 메시지 전송
			//tb_user_wish 삭제
			
			// user_wish 상태 코드 및 성공 메시지 전송
			resultBox.set("check", "ok");

		} catch (Exception ex) {
			ex.printStackTrace();
			resultBox.set("check", "fail");
		}
		return resultBox;
	}


