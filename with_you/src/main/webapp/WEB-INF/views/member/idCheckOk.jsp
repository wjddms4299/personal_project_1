<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	window.alert('${msg}');
	opener.document.memberJoin.id.value=${id};
	window.self.close();
</script>