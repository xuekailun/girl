# girl

## 不转义直接进行保存
	   /* 不转义 直接开始*/
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"));
            bw.newLine();
            for(Enumeration<?> e = prop.keys(); e.hasMoreElements();) {
                String key = (String)e.nextElement();
                String val = prop.getProperty(key);
                bw.write(key + "=" + val);
                bw.newLine();
            }
            bw.flush();
            /* 不转义 结束*/
