<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div id="emp-edit" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">
        <form class="w3-container" id="emp-edit-form">
            <div class="w3-section">
                <label><b>Ename</b></label>
                <input type="hidden" name="empno" id="empno"/>
                <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Ename"
                       name="Ename" id="ename" required>
            </div>
        </form>

        <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
            <span class="w3-right w3-padding w3-hide-small">
                <button onclick="document.getElementById('emp-edit').style.display='none'" type="button"
                        class="w3-button w3-red w3-margin-right">Cancel</button>
                <button type="button" id="submit"
                        class="w3-right w3-button w3-green">Submit</button>
            </span>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/emp/edit.js"></script>