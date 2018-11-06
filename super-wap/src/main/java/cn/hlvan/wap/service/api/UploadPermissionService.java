package cn.hlvan.wap.service.api;

import cn.hlvan.wap.view.UploadPermissionView;
import cn.hlvan.database.tables.records.SystemRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static cn.hlvan.database.Tables.PERMISSION;

@Service
@Transactional
public class UploadPermissionService {

    private DSLContext dsl;
    @Autowired
    public void setDsl(DSLContext dsl) {
        this.dsl = dsl;
    }

    public void addPermission(List<UploadPermissionView> uploadPermissionViews, SystemRecord systemRecord) {
        //权限信息插入表中
//        uploadPermissionViews.forEach(p ->
//            dsl.insertInto(PERMISSION).set(PERMISSION.SYSTEM_ID,systemRecord.getId())
//               .set(PERMISSION.CODE,p.getCode())
//               .set(PERMISSION.NAME,p.getName())
//               .onDuplicateKeyUpdate()
//               .set(PERMISSION.DESCRIPTION,p.getDescription())
//               .execute()
//        );
    }
}
