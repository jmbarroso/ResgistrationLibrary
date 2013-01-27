<div id="message-box" >
    <g:if test="${flash.error}">
        <div class="row" >
            <div class="span10">
                <div class="alert alert-error">
                    <i class="icon-exclamation-sign"> </i>
                    <g:message code="${flash.error}" args="${flash.args}"/>
                </div>
            </div>
        </div>
    </g:if>
    <g:if test="${flash.message}">
        <div class="row" >
            <div class="span10">
                <div class="alert alert-success">
                    <i class="icon-ok"> </i>
                    <g:message code="${flash.message}" args="${flash.args}"/>
                </div>
            </div>
        </div>
    </g:if>
</div>