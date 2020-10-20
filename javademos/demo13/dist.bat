@echo off

set PROJECT_ROOT=D:\OneDrive\myworks\corporate\20201002-lnt-effective-java\javademos\demo13

set DIST=%PROJECT_ROOT%\dist
set CLASSES=%PROJECT_ROOT%\classes

md %DIST%

cd %CLASSES%

jar cvf %DIST%\fa.jar .

cd %DIST%

echo @java -cp fa.jar in.conceptarchitect.app.FurnitureApp > fa.bat