@echo off

set PROJECT_ROOT=D:\OneDrive\myworks\corporate\20201002-lnt-effective-java\javademos\demo13

set DIST=%PROJECT_ROOT%\dist
set CLASSES=%PROJECT_ROOT%\classes

md %DIST%

cd %CLASSES%

jar cvmf ../meta.txt %DIST%\fa2.jar .

cd %DIST%

echo @java -jar fa2.jar  > fa2.bat