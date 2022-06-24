<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="${contextRoot}/css/bootstrap.min.css" />
  <link rel="stylesheet" href="${contextRoot}/css/all.min.css"/>
    <link rel="stylesheet" href="${contextRoot}/css/cart.css">
  
    <script src="${contextRoot}/js/jquery-3.6.0.min.js"></script>
    <script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<div class="container mt-5" >
        <div class="h1 text-center"><strong>六角血拚 訂單確認</strong></div>
        <div class="row mt-3">
            <div class="col-12 col-md">
                <div class="alert alert-success alert-rounded text-center" role="alert">1.輸入訂單資料</div>
            </div>
            <div class="col-12 col-md">
                <div class="alert alert-light alert-rounded text-center" role="alert">2.金流付款</div>
            </div>
            <div class="col-12 col-md">
                <div class="alert alert-light alert-rounded text-center" role="alert">3.訂單完成</div>
            </div>
        </div>

        <div class="row justify-content-center mt-4">
            <div class="col-md-8">
                <div class="accordion" id="accordionExample">
                    <div class="card card-bottom">
                        <div class="card-header  d-flex justify-content-between" id="headingOne">
                            <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne"
                                aria-expanded="true" aria-controls="collapseOne">
                                顯示購物車細節
                            </button>
                            <div class="h3 d-inline-block mt-2">
                                <strong>$ 1059</strong>
                            </div>
                        </div>

                    </div>
                    <div id="collapseOne" class="collapse show " aria-labelledby="headingOne" data-parent="#accordionExample">
                        <table class="table table-sm">
                            <thead>
                                <tr>
                                    <th width="20"></th>
                                    <th width="100"></th>
                                    <th> 商品名稱</th>
                                    <th>數量</th>
                                    <th class="text-center" width="120">小計</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="align-middle"><a href="#removeModal" class="text-dark" data-price="999"
                                            data-title="一級偽裝帽" data-toggle="modal" data-target="#removeModal"><i class="far fa-trash-alt mr-3"></i></a></td>
                                    <td class="align-middle">
                                        <div class="card p-1 card-bottom">
                                            <img src="https://images.unsplash.com/photo-1447005497901-b3e9ee359928?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=967&q=80"
                                                alt="..." width="80px;">
                                        </div>
                                    </td>
                                    <td class="align-middle "> 一級偽裝帽</td>
                                    <td class="align-middle">1件</td>
                                    <td class="align-middle text-right">$999</td>
                                </tr>
                                <tr class="text-right">
                                    <td colspan="4"><strong>運費</strong></td>
                                    <td><strong>$ 60</strong></td>
                                </tr>
                                <tr class="text-right">
                                    <td colspan="4"><strong>合計</strong></td>
                                    <td><strong>$ 1059</strong></td>
                                </tr>
                            </tbody>

                        </table>


                    </div>
                </div>

                <div class="card text-center my-5 border-0">
                    <div class="card-header border-0">
                        <div class="h3 mt-1"> 訂購人資訊 </div>
                    </div>
                    <form class="needs-validation" novalidate>
                        <div class="form-row text-left mt-3">
                            <div class="form-group col-md-6">
                                <label for="name">姓名</label>
                                <input type="text" class="form-control " id="name" placeholder="姓名" required>
                                <div class="invalid-feedback">請填寫姓名</div>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="mail">Email</label>
                                <input type="email" class="form-control" id="mail" placeholder="Email" required>
                                <div class="invalid-feedback">請填寫Email</div>
                            </div>
                        </div>
                        <div class="form-row text-left">
                            <div class="form-group col-md-4">
                                <label for="section">國家</label>
                                <select name="" id="section" class="form-control">
                                    <option value="">台灣</option>
                                    <option value="">...</option>
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="zone">城市</label>
                                <select name="" id="zone" class="form-control">
                                    <option value="">台北市</option>
                                    <option value="">台中市</option>
                                    <option value="">高雄市</option>
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="postal-code">郵遞區號</label>
                                <input type="text" class="form-control" id="postal-code" placeholder="" required>
                            </div>
                        </div>
                        <div class="form-row">
                            <label for="address">地址</label>
                            <input type="text" class="form-control" id="mail" placeholder="永遠開心一路123號" required>
                        </div>
                        <div class="mt-3 d-flex justify-content-end">
                            <button class="btn btn-secondary mr-2">繼續選購</button>
                            <button type="submit" class="btn btn-primary">確認付款</button>
                        </div>
                    </form>

                    <script>
                        // Example starter JavaScript for disabling form submissions if there are invalid fields
                        (function () {
                            'use strict';
                            window.addEventListener('load', function () {
                                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                                var forms = document.getElementsByClassName('needs-validation');
                                // Loop over them and prevent submission
                                var validation = Array.prototype.filter.call(forms, function (form) {
                                    form.addEventListener('submit', function (event) {
                                        if (form.checkValidity() === false) {
                                            event.preventDefault();
                                            event.stopPropagation();
                                        }
                                        form.classList.add('was-validated');
                                    }, false);
                                });
                            }, false);
                        })();
                    </script>

                </div>
            </div>
        </div>

    </div>
</body>
</html>