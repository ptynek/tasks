call ./runcrud
if "%ERRORLEVEL%" == "0" goto browser
echo.
echo Cannot open runcrud
goto fail

:browser
sleep 15s
start chrome http://localhost:8080/crud/v1/tasks
if "%ERRORLEVEL%" == "0" goto finish
echo.
echo Problem with browser

:fail
echo.
echo There were errors

:finish
echo.
echo Work is finished