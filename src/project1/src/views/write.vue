<template>
    <div class="controller">
		<div id="wriTitle" ><b>글 작성</b></div>
	<form action="/writeaction" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td><input type="text" name="bTitle" placeholder="제목을 입력하세요" required id = "title" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><textarea rows="12" cols="50" placeholder="내용을 입력하세요" name="bContent" required></textarea></td>
			</tr>
			<tr>
				<td><input type = "file" name = "files" multiple="multiple"/> </td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="등록" class="button"></td>
			</tr>
	</table>
	</form>
	</div>
</template>