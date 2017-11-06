package ma.pm.distribution.controllers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/download")
public class FileDownloadController {
	
	@RequestMapping(value="/{type}/")
	public void downloadModel(HttpServletResponse response, @PathVariable("type") String type ) throws IOException{
		File file=null;
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		
		if(type.equals("fexcel2007plus")) {
			file = new File(classloader.getResource("excelfiles/FModel_2007+.xlsx").getFile());
		}
		else if(type.equals("texcel2007plus")){
			file = new File(classloader.getResource("excelfiles/TModel_2007+.xlsx").getFile());
		}
		else if(type.equals("fexcel97to2003")) {
			file = new File(classloader.getResource("excelfiles/FModel_97-2003.xls").getFile());
		}else {
			file = new File(classloader.getResource("excelfiles/TModel_97-2003.xls").getFile());
		}
        
        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType==null){
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }
         
        System.out.println("mimetype : "+mimeType);
         
        response.setContentType(mimeType);
        
        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
        while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));

     
        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        response.setContentLength((int)file.length());

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
	}
	
}
