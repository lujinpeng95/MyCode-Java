:: win-bat
git add .

set "commit=%~1"
setlocal EnableDelayedExpansion
if "!commit!"==""  (
	git commit -m "�ճ�����"
) else (
	git commit -m %1
)

git push github-origin main
git push gitee-origin main
pause