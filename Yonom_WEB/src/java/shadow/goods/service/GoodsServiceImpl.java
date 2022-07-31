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
			ABoxList<ABox> goodsList = commonDao.selectList("mybatis.shadow.goods.goods_mapper.selectGoodsListSQL", paramBox);
			if(goodsList.size() > 0) {
				resultBox.set("goods-list", goodsList);
				resultBox.set("count", goodsList.size());
				resultBox.set("check", "ok");
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
	public ABox selectSalesRecord(ABox paramBox) {
		ABox resultBox = new ABox();
		try {
			ABoxList<ABox> goodsList = commonDao.selectList("mybatis.shadow.goods.goods_mapper.selectGoodsRecordListSQL", paramBox);
			if(goodsList.size() > 0) {
				resultBox.set("goods-list", goodsList);
				resultBox.set("count", goodsList.size());
				resultBox.set("check", "ok");
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
	public ABox salesGoods(ABox paramBox) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ABox requestPurchase(ABox paramBox) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ABox chooseBuyer(ABox paramBox) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
