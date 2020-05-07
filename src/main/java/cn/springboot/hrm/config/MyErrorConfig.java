package cn.springboot.hrm.config;



import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author zyw
 * @version 1.0
 * @date 2020/4/27 22:21
 */
@Component
public class MyErrorConfig implements ErrorPageRegistrar {

  @Override
  public void registerErrorPages(ErrorPageRegistry registry) {
    ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/errorPage/400");
    ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/errorPage/401");
    ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/errorPage/404");
    ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/errorPage/500");
    registry.addErrorPages(error400Page, error401Page, error404Page, error500Page);
  }
}
