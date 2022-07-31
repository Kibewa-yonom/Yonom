package shadow.goods.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import common.collection.ABox;
import common.collection.ABoxList;
import common.service.SuperService;

/**
 * <pre>
 *  채팅 서비스 클래스 정의
 * </pre>
 */

@Service
@Transactional(propagation = Propagation.REQUIRED) // 서비스 클래스의 모든 메서드에 트랜잭션을 적용
public class GoodsServiceImpl extends SuperService implements GoodsService {

	@Override
	public ABox selectGoods(ABox paramBox) {
		ABox resultBox = new ABox();
		try {
			ABoxList<ABox> goodsList = new ABoxList<ABox>();
			paramBox.set("goodsState", "GS01");
			goodsList = commonDao.selectList("mybatis.goods.goods_mapper.selectGoodsListSQL", paramBox);
			if(goodsList.size() > 0) {
				resultBox.set("goods-list", goodsList);
				resultBox.set("count", goodsList.size());
				resultBox.set("check", "ok");
				
				//TODO sql 조회문 수정 
				//TODO 이미지 모듈 부착 
				//TODO 동적 limit 의논 
			} else {
				resultBox.set("count", 0);
				resultBox.set("check", "empty");
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			resultBox.set("check", "fail");
		}
		return resultBox;
	}
	
	@Override
	public ABox findGoods(ABox paramBox) {
		ABox resultBox = new ABox();
		try {
			ABox goodsBox = new ABox();
			ABox wishBox = new ABox(); 
			
			goodsBox = commonDao.select("mybatis.goods.goods_mapper.selectGoodsSQL", paramBox);
			if(goodsBox.isEmpty()) {
				resultBox.set("check", "empty");	
			} else {
				if(!goodsBox.getString("GOODS_STATE").equals("GS01")) {
					resultBox.set("check", "forbidden");	
				} else {
					wishBox = commonDao.select("mybatis.goods.goods_mapper.selectWishSQL", paramBox);
					resultBox.set("goods", goodsBox);
					resultBox.set("wish", wishBox);
					resultBox.set("check", "ok"); 
				}			
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			resultBox.set("check", "fail");
		}
		return resultBox;
	}

	@Override
	public ABox selectSalesRecord(ABox paramBox) {
		ABox resultBox = new ABox();
		try {
			ABoxList<ABox> goodsList = new ABoxList<ABox>();
			goodsList = commonDao.selectList("mybatis.goods.goods_mapper.selectSaleRecordListSQL", paramBox);
			if(goodsList.size() > 0) {
				resultBox.set("goods-list", goodsList);
				resultBox.set("count", goodsList.size());
				resultBox.set("check", "ok");
				
				//TODO sql 조회문 수정 
				//TODO 이미지 모듈 부착 
				//TODO 동적 limit 의논 
			} else {
				resultBox.set("count", 0);
				resultBox.set("check", "empty");
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			resultBox.set("check", "fail");
		}
		return resultBox;
	}

	@Override
	public ABox registerGoods(ABox paramBox) throws DataAccessException {
		ABox resultBox = new ABox();
		try {
			resultBox.set("check", "ok");

		} catch (Exception ex) {
			ex.printStackTrace();
			resultBox.set("check", "fail");
		}
		return resultBox;
	}

	@Override
	public ABox requestPurchase(ABox paramBox) throws DataAccessException {
		ABox resultBox = new ABox();
		try {
			resultBox.set("check", "ok");

		} catch (Exception ex) {
			ex.printStackTrace();
			resultBox.set("check", "fail");
		}
		return resultBox;
	}


	@Override
	public ABox chooseBuyer(ABox paramBox) throws DataAccessException {
		ABox resultBox = new ABox();
		try {
			resultBox.set("check", "ok");

		} catch (Exception ex) {
			ex.printStackTrace();
			resultBox.set("check", "fail");
		}
		return resultBox;
	}

}
