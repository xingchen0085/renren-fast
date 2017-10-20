package io.renren.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;


/**
 * 生成验证码配置
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-04-20 19:22
 */
@Configuration
public class KaptchaConfig {

    @Bean
    public DefaultKaptcha producer() {
        Properties properties = new Properties();
        properties.put("kaptcha.border", "no");                         // 验证码图片是否带有边框
        properties.put("kaptcha.textproducer.font.color", "red");       // 验证码的颜色
        properties.put("kaptcha.textproducer.char.space", "5");         // 验证码字符所占位置的大小
        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
