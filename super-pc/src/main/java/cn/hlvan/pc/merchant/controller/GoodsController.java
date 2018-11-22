package cn.hlvan.pc.merchant.controller;

import cn.hlvan.database.tables.Goods;
import cn.hlvan.database.tables.GoodsClassify;
import cn.hlvan.database.tables.records.BrandRecord;
import cn.hlvan.database.tables.records.GoodsRecord;
import cn.hlvan.pc.security.session.Authenticated;
import cn.hlvan.pc.util.Reply;
import cn.hlvan.pc.view.ClassifyList;
import cn.hlvan.service.merchant.GoodsService;
import com.google.gson.Gson;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static cn.hlvan.database.tables.Brand.BRAND;
import static cn.hlvan.database.tables.Goods.GOODS;
import static cn.hlvan.database.tables.GoodsClassify.GOODS_CLASSIFY;

@Controller("merchantGoodsController")
@RequestMapping("/merchant/goods")
public class GoodsController {

    private DSLContext dsl;

    private GoodsService goodsService;

    @Autowired
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Autowired
    public void setDsl(DSLContext dsl) {
        this.dsl = dsl;
    }

    private Gson gson;

    @Autowired
    public void setGson(Gson gson) {
        this.gson = gson;
    }

    @GetMapping("/list")
    @ResponseBody
    public Map goodsList(int start, int length, int draw){
        List<GoodsRecord> goods = dsl.selectFrom(GOODS).fetch();
        Integer count = dsl.selectCount().from(GOODS).limit(start, length).fetchOneInto(Integer.class);
        Map<String, Object> map = new HashMap<>();

        map.put("data", goods);
        map.put("recordsTotal", count);
        map.put("recordsFiltered", count);
        map.put("draw", draw);
        return map;
    }

    @RequestMapping("/view")
    public String view(Model model){

        List<BrandRecord> brands = dsl.selectFrom(BRAND).where(BRAND.ENABLED.eq(true)).fetch();
        model.addAttribute("brands",brands);
        return "/merchant/goods";
    }

    @PostMapping("/create")
    @ResponseBody
    public Reply create(GoodsService.GoodsForm goodsForm, @Authenticated AuthorizedUser authorizedUser){

        goodsForm.setMerchantId(authorizedUser.getId());
        goodsService.create(goodsForm);
        return Reply.success();
    }
    @RequestMapping("/classify/list")
    @ResponseBody
    public List<ClassifyList> list  () {
        GoodsClassify a = GOODS_CLASSIFY.as("a");
        GoodsClassify b = GOODS_CLASSIFY.as("b");
        List<ClassifyList> classifyLists = dsl.select(GOODS_CLASSIFY.ID, GOODS_CLASSIFY.NAME,
            GOODS_CLASSIFY.P_ID.as("pId")).from(GOODS_CLASSIFY)
                                              .where(GOODS_CLASSIFY.ENABLED.eq(true))
                                              .fetchInto(ClassifyList.class);

        Set<Integer> l = dsl.select(a.ID).from(a).innerJoin(b).on(a.ID.eq(b.P_ID)).fetchSet(a.ID);
        classifyLists.forEach(e -> {
            if (e.getpId() == 0 || l.contains(e.getId())){
                e.setNocheck(true);
                e.setOpen(true);
            }
        });
        return classifyLists;

    }
}
