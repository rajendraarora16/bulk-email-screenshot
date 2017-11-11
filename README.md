# Bulk Email Screenshot

If you are tired opening multiple email accounts (Let's say you have 50+ gmail accounts). Don't worry this program is going to help you in a nice way :)

This will take screenshot your inbox in background process. All you need to run `java TakeScreenshot.java` and Boom!! Within in a couple of minutes you will have a screenshot of inbox with all your accounts associated something like below in a selected folder. You don't need to sign in again and again. Let all your massive things rest by running this program itself. 

**Usage:**

You need to include selenium library and setup chrome driver executable file.

In `TakeScreenshot.java`, enter your multiple user email and password:

    String[] emailLogin = new String[]{
        "demo1@gmail.com",
        "demo2@gmail.com",
        "So on ..."
    };
    		
    String[] emailPass = new String[]{
        "your pass1",
        "your pass2",
        "So on ..."
    };



