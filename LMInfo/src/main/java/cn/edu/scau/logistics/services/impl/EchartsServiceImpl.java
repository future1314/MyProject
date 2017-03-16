package cn.edu.scau.logistics.services.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import net.sf.json.JSONObject;
import cn.edu.scau.logistics.dao.OrderDetailDao;
import cn.edu.scau.logistics.entity.Money;
import cn.edu.scau.logistics.entity.Series;
import cn.edu.scau.logistics.services.interfaces.EchartsService;

@Service("echarts")
public class EchartsServiceImpl implements EchartsService {
	@Resource
	private OrderDetailDao orderDetailDao;
	private List<Integer> profitList;
	private List<Integer> incomeList;
	private List<Integer> freightList;
	
	
	@Override
	public JSONObject getJsonObject(String start, String end) {
		// TODO Auto-generated method stub
		List<Money> moneyList = orderDetailDao.findByData(start, end);//获得收入，运费LIST
		List<String> xAxisData  = new ArrayList<String>();
		List<JSONObject> seriesList = new ArrayList<JSONObject>();
		profitList = new ArrayList<Integer>();
		incomeList = new ArrayList<Integer>();
		freightList = new ArrayList<Integer>();
		JSONObject jsonObject = new JSONObject();
		Integer profit = 0;
		Integer income = 0;
		Integer freight = 0;
		System.out.println("size:"+moneyList.size());
		for(int i=0; i<moneyList.size();i++){
			//录入时间
			
			xAxisData.add(moneyList.get(i).getOrdersTime());
			income = getResult(moneyList.get(i).getIncome());
			freight = getResult(moneyList.get(i).getFreight());
			profit = income - freight;
			profitList.add(profit);//利润
			incomeList.add(income);
			freightList.add(freight);
			
		}
		Series incomeSeries = new Series("收入",Series.TYPE_BAR,incomeList);
		seriesList.add(JSONObject.fromObject(incomeSeries));
		Series freightSeries = new Series("运费",Series.TYPE_BAR,freightList);
		seriesList.add(JSONObject.fromObject(freightSeries));
		Series profitSeries = new Series ("利润",Series.TYPE_BAR,profitList);
		seriesList.add(JSONObject.fromObject(profitSeries));
		jsonObject.put("xAxisData",xAxisData);
		jsonObject.put("seriesList", seriesList);
		
		return jsonObject;
	}
	
	
	public Integer getResult(String str){
		Integer result = 0;
		if(str == null)
			result = 0;
		else
			result = Integer.parseInt(str);		
		return  result;
	}

}
