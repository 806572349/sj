package com.nemo.sj.system.after;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
/**
 * //                       .::::.
 * //                     .::::::::.
 * //                    :::::::::::
 * //                 ..:::::::::::'
 * //              '::::::::::::'
 * //                .::::::::::
 * //           '::::::::::::::..
 * //                ..::::::::::::.
 * //              ``::::::::::::::::
 * //               ::::``:::::::::'        .:::.
 * //              ::::'   ':::::'       .::::::::.
 * //            .::::'      ::::     .:::::::'::::.
 * //           .:::'       :::::  .:::::::::' ':::::.
 * //          .::'        :::::.:::::::::'      ':::::.
 * //         .::'         ::::::::::::::'         ``::::.
 * //     ...:::           ::::::::::::'              ``::.
 * //    ```` ':.          ':::::::::'                  ::::..
 * //                       '.:::::'                    ':'````..
 * //      码中自有黄金屋
 */

/**
 * create by Nemo
 * 2018/8/15  16:52
 */
@Component
@Slf4j
public class ApplicationRunner  implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        System.out.println("项目正在初始化>>>>>>>>>>>>>>");
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("//                       .::::. \r\n");
        stringBuilder.append("//                     .::::::::. \r\n");
        stringBuilder.append("//                    :::::::::::\n");
        stringBuilder.append("//                 ..:::::::::::'\n");
        stringBuilder.append("//              '::::::::::::'\n");
        stringBuilder.append("//                .::::::::::\n");
        stringBuilder.append("//           '::::::::::::::..\n");
        stringBuilder.append("//                ..::::::::::::.\n");
        stringBuilder.append("//              ``::::::::::::::::\n");
        stringBuilder.append("//               ::::``:::::::::'        .:::.\n");
        stringBuilder.append("//              ::::'   ':::::'       .::::::::.\n");
        stringBuilder.append("//            .::::'      ::::     .:::::::'::::.\n");
        stringBuilder.append("//           .:::'       :::::  .:::::::::' ':::::.\n");
        stringBuilder.append("//          .::'        :::::.:::::::::'      ':::::.\n");
        stringBuilder.append("//         .::'         ::::::::::::::'         ``::::.\n");
        stringBuilder.append("//     ...:::           ::::::::::::'              ``::.\n");
        stringBuilder.append("//    ```` ':.          ':::::::::'                  ::::..\n");
        stringBuilder.append("//                       '.:::::'                    ':'````..\n");
        stringBuilder.append("//             码中自有黄金屋");
        System.out.println(stringBuilder.toString());
        System.out.println("完成!!!!!!!!!!!!");
    }
}
