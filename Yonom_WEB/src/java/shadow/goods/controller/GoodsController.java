package shadow.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import common.collection.ABox;
import common.controller.SuperController;
import shadow.goods.service.GoodsService;
import shadow.nft.service.NftService;

@RequestMapping("/goods")
@RestController
public class GoodsController extends SuperController{

	@Autowired
	GoodsService goodsService;
	
	@RequestMapping(value = "/", produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity<String> apiController()throws Exception {
		String result = "";
		try {
			result = "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(result, HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

}
