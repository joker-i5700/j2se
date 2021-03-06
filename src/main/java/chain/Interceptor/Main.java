package chain.Interceptor;

import com.google.common.collect.Lists;

import java.util.List;

/**
 *
 * https://www.oracle.com/technetwork/java/interceptingfilter-142169.html
 * https://github.com/iluwatar/java-design-patterns/tree/master/intercepting-filter
 * https://juejin.im/post/5ad40ee1f265da2375075a23
 * https://www.baeldung.com/chain-of-responsibility-pattern
 * https://www.baeldung.com/intercepting-filter-pattern-in-java
 * https://my.oschina.net/redraiment/blog/105209
 * http://www.tutorialspoint.com/design_pattern/intercepting_filter_pattern.htm
 * @author beigua
 */
public class Main {
    public static void main(String[] args) {
        List<Interceptor> interceptorList = Lists.newArrayList();

        Interceptor i1 = (target, request) -> doProceed(target, request);

        Interceptor i2 = (target, request) -> doProceed(target, request);

        interceptorList.add(i1);
        interceptorList.add(i2);

        Request request = new Request();
        Response proceed = new InterceptorChain(interceptorList, new DefaultHandler()).proceed(request);
        System.out.println("req" + request);
        System.out.println("rsp" + proceed);

    }

    private static Response doProceed(Interceptor.InvocationTarget target, Request request) {
        Response res = target.proceed(request);
        int reqNo = request.getReqNo();
        request.setReqNo(++reqNo);
        int rspNo = res.getRspNo();
        res.setRspNo(++rspNo);
        return res;
    }
}
