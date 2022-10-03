package cardstore.proxy;

//靜態代理模式 不實用 若其他地方也需要日誌功能 需要宣告更多類 產生大量重複代碼 日誌功能分散,沒有統一管理
public class CalculatorStaticProxy implements Calculator {
	// 將被代理的目標宣告為成員變數 介面與實現類都可以
    private Calculator target;
    
    public CalculatorStaticProxy(Calculator target) {
        this.target = target;
    }
    
    @Override
    public int add(int i, int j) {
    
        // 附加功能由代理類中的代理方法来實現
        System.out.println("[log] add 方法開始了，参数是：" + i + "," + j);
    
        // 通過目標對象實現核心業務邏輯
        int addResult = target.add(i, j);
    
        System.out.println("[log] add 方法结束了，结果是：" + addResult);
    
        return addResult;
    }

	@Override
	public int sub(int i, int j) {
		// 附加功能由代理類中的代理方法来實現
        System.out.println("[log] sub 方法開始了，参数是：" + i + "," + j);
    
        // 通過目標對象實現核心業務邏輯
        int subResult = target.sub(i, j);
    
        System.out.println("[log] sub方法结束了，结果是：" + subResult);
    
        return subResult;
	}

	@Override
	public int mul(int i, int j) {
		// 附加功能由代理類中的代理方法来實現
        System.out.println("[log] mul 方法開始了，参数是：" + i + "," + j);
    
        // 通過目標對象實現核心業務邏輯
        int mulResult = target.mul(i, j);
    
        System.out.println("[log] mul 方法结束了，结果是：" + mulResult);
    
        return mulResult;
	}

	@Override
	public int div(int i, int j) {
		// 附加功能由代理類中的代理方法来實現
        System.out.println("[log] div 方法開始了，参数是：" + i + "," + j);
    
        // 通過目標對象實現核心業務邏輯
        int divResult = target.div(i, j);
    
        System.out.println("[log] add 方法结束了，结果是：" + divResult);
    
        return divResult;
	}
}
