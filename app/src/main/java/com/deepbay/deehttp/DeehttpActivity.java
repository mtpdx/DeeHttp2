package com.deepbay.deehttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.deepbay.deehttp.cache.CacheConstants;
import com.deepbay.deehttp.cache.DiskCacheManager;
import com.deepbay.deehttp2.DeeApiManager;
import com.deepbay.deehttp2.DeeResponse;
import com.google.gson.Gson;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

public class DeehttpActivity extends AppCompatActivity {

  private Gson gson;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_deehttp);
    gson = new Gson();
    findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        //init();
        getCate();
      }
    });

    findViewById(R.id.tvv).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        initt();
      }
    });
  }

  private void getCate() {
    DeeApiManager.getInstence().getMobile().getCatDetail(104007,1,1,0)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<DeeResponse>() {
          @Override public void onSubscribe(Disposable d) {

          }

          @Override public void onNext(DeeResponse deeResponse) {
            System.out.println(gson.toJson(deeResponse));

          }

          @Override public void onError(Throwable e) {
            e.printStackTrace();

          }

          @Override public void onComplete() {
            System.out.println("complete cat");
          }
        });
  }

  private void initt() {
    DeeApiManager.getInstence()
        //.genTokenClient("Ciih8PWJUPomHW9+/XVoDpdeV+W7OsCE58nfie6EtTcvSmCrGhzCSWF7kLMhlyUf")
        .getShop().getOrderAll().subscribeOn(Schedulers.io()).observeOn(Schedulers.io())
        //.flatMap(new Function<DeeResponse, ObservableSource<DeeFun<String>>>() {
        //  @Override public ObservableSource<DeeFun<String>> apply(DeeResponse deeResponse)
        //      throws Exception {
        //    if (deeResponse.getState() == 0){
        //      return Observable.create(new ObservableOnSubscribe<DeeFun<String>>() {
        //        @Override public void subscribe(ObservableEmitter<DeeFun<String>> emitter)
        //            throws Exception {
        //
        //        }
        //      });
        //    }
        //    return null;
        //  }
        //})
       .subscribe(new Consumer<DeeResponse>() {
         @Override public void accept(DeeResponse deeResponse) throws Exception {

         }
       });
  }

  private void init() {
    DeeApiManager.getInstence()
        .genTokenClient("Ciih8PWJUPomHW9+/XVoDpdeV+W7OsCE58nfie6EtTcvSmCrGhzCSWF7kLMhlyUf")
        .getMobile()
        .getPanicBuy()
        .map(new Function<DeeResponse, DeeResponse<List<ProductItemBean>>>() {
          @Override public DeeResponse apply(DeeResponse deeResponse) throws Exception {
            if (deeResponse.getState() != 0){
              throw new DeeApiException(deeResponse.getState(),deeResponse.getStateSmg());
            }
            return deeResponse;
          }
        })
        .map(new Function<DeeResponse<List<ProductItemBean>>, ArrayList<ProductItemBean>>() {
          @Override
          public ArrayList<ProductItemBean> apply(DeeResponse<List<ProductItemBean>> listDeeResponse)
              throws Exception {
            ArrayList<ProductItemBean> productItemBeans = new ArrayList<>();
            productItemBeans.addAll(listDeeResponse.getData());
            return productItemBeans;
          }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<ArrayList<ProductItemBean>>() {
          @Override public void onSubscribe(Disposable d) {

          }

          @Override public void onNext(ArrayList<ProductItemBean> productItemBeans) {
            DiskCacheManager cacheManager = new DiskCacheManager(DeehttpActivity.this,
                CacheConstants.CACHE_MOBILE_FILE);
            cacheManager.put(CacheConstants.CACHE_PANIC_BUY,productItemBeans);

            initView(productItemBeans);
          }

          @Override public void onError(Throwable e) {
            getDataByCache();
          }

          @Override public void onComplete() {

          }
        });
  }

  private void getDataByCache() {
    DiskCacheManager cacheManager = new DiskCacheManager(DeehttpActivity.this,
        CacheConstants.CACHE_MOBILE_FILE);
    ArrayList<ProductItemBean> itemBeans = cacheManager.getSerializable(CacheConstants.CACHE_PANIC_BUY);
    initView(itemBeans);
  }

  private void initView(ArrayList<ProductItemBean> productItemBeans) {

  }

  //将所有正在处理的Subscription都添加到CompositeSubscription中。统一退出的时候注销观察
  private CompositeDisposable mCompositeDisposable;

  private void addDisposable(Disposable subscription) {
    if (mCompositeDisposable == null
        || mCompositeDisposable.isDisposed()) { //csb 如果解绑了的话添加 sb 需要新的实例否则绑定时无效的
      mCompositeDisposable = new CompositeDisposable();
    }
    mCompositeDisposable.add(subscription);
  }

  //在界面退出等需要解绑观察者的情况下调用此方法统一解绑，防止Rx造成的内存泄漏
  public void dispose() {
    if (mCompositeDisposable != null) {
      mCompositeDisposable.dispose();
    }
  }
}
