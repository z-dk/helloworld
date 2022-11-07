package com.zdk.hello.util;

import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * <b>类 名 称</b> :  TransactionUtil<br/>
 * <b>类 描 述</b> :  事务<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/11/7 21:17<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/11/7 21:17<br/>
 * <b>修改备注</b> :  <br/>
 * 事务中处理一些事情:事务执行完成后执行一些操作
 * @author zdk
 */
public class TransactionUtil {

    public static void doSomethingAfterCommitted(TransactionJob transactionJob) {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionSynchronizationManager.registerSynchronization(transactionJob);
        }
    }
    
}

class TransactionJob implements TransactionSynchronization {

    private final Runnable runnable;

    public TransactionJob(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void afterCompletion(int status) {
        // 事务提交之后,执行一些回调操作
        if (status == TransactionSynchronization.STATUS_COMMITTED) {
            runnable.run();
        }
    }
}
