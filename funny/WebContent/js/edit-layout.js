$(document).ready(function() {
	CKEDITOR.replace('editor', {
		filebrowserImageUploadUrl: '/image.im',
		//filebrowserUploadUrl :'/image.im',
		//config.filebrowserUploadUrl      = '/upload.do?type=Files',
		//config.filebrowserImageUploadUrl = '/upload.do?type=Images',

		width: '100%', 
		height: '800px',  
		
	});

})


/*
let editor;


$('#send').on('click', () => {
	event.defaultPrevented();
	alert('test');
	const editData = editor.getData();


	$('board_content').value = $('#editor').val();

	console.log(editData);
})


var CustomUploadAdapter = function (loader, path, fn_resolve) {
	this.constructor = function (loader) {
		this.loader = loader;
		this.path = path;
		this.fn_resolve = fn_resolve;
	}
		;
	this.upload = function () {
		return new Promise(function (resolve, reject) {
			this.xhr = ajax_file_upload({
				loader: loader, resolve: resolve, reject: reject, files: [loader.file], path: path, fn_progress: function (e) {
					e.lengthComputable && (loader.uploadTotal = e.total, loader.uploaded = e.loaded);
				}
				, fn_success: function (e) {
					resolve(fn_resolve && fn_resolve(e));
				}
				, fn_error: function (e) {
					reject("upload fail =>" + `$ {
    loader.file.name;
}
.`);
				}
				, fn_abort: reject
			});
		}
		);
	}
		;
	this.abort = function () {
		return this.xhr.abort && this.xhr.abort();
	}
};
function ajax_file_upload(p) {				if (!p.files || !p.loader || !p.path) return new XMLHttpRequest;				var formData = new FormData();		for (var idx in p.files) {			formData.append("uploadfile", p.files[idx]);		}		formData.append("path", p.path);				return $.ajax({			url: '/api/common/fileupload',			processData: false,			contentType: false,			data: formData,			type: 'POST',			onprogress: function (e) {				p.fn_progress && p.fn_progress(e);			},			success: function(e){				p.fn_success && p.fn_success(e);			},			error: function (e) {				p.fn_error && p.fn_error;			},			abort: function (e) {				p.fn_abort && p.fn_abort(e);			}		});	}

/*
	비동기 처리를 이용해 이미지를 먼저 서버로 전송
*/
/*
$('send').ready('click',function(e) {
	e.defaultPrevented();

	return new Promise(function() {

	})
})

*/