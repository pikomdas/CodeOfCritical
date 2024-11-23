/*
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.TECHMAHINDRA.COM PRIVACY POLICY © 2012
 * AnalyticsHooks.java belongs to AssetVantage
 * Do not COPY or PASTE code to WEB from TemenosT24
 * Creation date-time : 09-Oct-2019 12:04:24 PM
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */
package com.codeOfCritical.Hooks;

import com.codeOfCritical.BaseClass.Browser;

/**
 * @author partha.das
 */
public class AnalyticsHooks extends Browser
{

	/*private static final Logger log = LogManager.getLogger(AnalyticsHooks.class.getName());

	public AnalyticsHooks()
	{
		log.info("_____________ INITIALIZE CUSTOM HOOKS(ANALYTICS) FOR ASSETVANTAGE APPLICATION _____________");
	}

	@Before("@WR_Accrued_Income or @Essvee_WR or @Prod_smoke_test_WR_Valuation or @Existing_WR_report_download or @Prod_smoke_test_WR or @Test_WR or @ZeroCouponBonds_WR or @Existing_WR_report or "
			+ "@exisitng_wealthregister_CBA or @existing_wealthregister_MGHC or @existing_wealthregister_ZeroCouponBond or @existing_wealthregister_transferin or @WR_CBA or @WR_ROC or "
			+ "@WR_BondAmortization or @Demerger_WR or @WR_Transfer or @Apar_WR or @RRC_WR or @Milestone_WR or @Listed_ZCB_USD_WR or @Listed_ZCB_USD or @existing_WR_Options or @WR_FilterSummation or "
			+ "@Thakor_WR or @Gopalan_WR or @GhallaBhansali_WR or @Blueedge_WR or @PeopleCombine_WR or @Indorama_Detailed_WR or @Divisa_WR or @SquareOffPosition_WR or @Lemuir_Detailed_WR or @Optimized_WR")
	public void WR_REPORT_CHECK(Scenario scenario) throws Exception
	{

		@SuppressWarnings("unused")
		CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
		homePageCommon hpc = new homePageCommon(driverThread.get());
		hpc.clickOnMenuThenClickOnAnalytics();
		analytics a = new analytics(driverThread.get());
		a.clickOnOptimizedWealthRegisterLink();
	}

	@Before("@PPS_TWR or @Prod_smoke_test_PPS or @Test_PPS or @ZeroCouponBonds_PPS or @PPS_Report_Check or @Existing_PPS_report or @existing_PPS_report_CBA or @existing_PPS_report_MGHC or "
			+ "@existing_PPS_report_ZeroCouponBond or @existing_PPS_report_transferin or @CBA_PPS or @ROC_PPS or @Transfer_PPS or @PPS_BondAmortization or @Demerger_PPS or @PPS_Accrued_Income or "
			+ "@Merger_PPS or @PositionLevel_TWR or @SummationLevel_TWR or @existing_PPS_report_Drivatives_Options or @Listed_ZCB_PPS_USD or @existing_PPS_report_ZCB_Listed or @PPS_FilterSummation")
	public void PPS_Report_Check(Scenario scenario) throws Exception
	{
		@SuppressWarnings("unused")
		CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
		homePageCommon hpc = new homePageCommon(driverThread.get());
		hpc.clickOnMenuThenClickOnAnalytics();
		analytics a = new analytics(driverThread.get());
		a.clickOnportFolioPerformanceLink();
	}

	@Before("@Gains_LTCG or @Prod_SKP_Gains or @Prod_smoke_test_GAINS or @Test_GAINS or @ZeroCouponBonds_GainsUnrealized or @ZeroCouponBonds_Gainsrealized or @GAINS_Report_Check or "
			+ "@existing_GAINS_report_CBA or @existing_GAINS_report_CBA_unrealized or @existing_GAINS_report_MGHC or @existing_GAINS_report_MGHC_unrealized or @existing_GAINS_report_ZeroCouponBond or"
			+ " @existing_GAINS_report_ZeroCouponBond_unrealized or "
			+ "@existing_GAINS_report_transferin or @existing_GAINS_report_transferin_unrealized or @Existing_Gain_Report or @CBA_Gainsrealized or @CBA_GainsUnrealized or @ROC_Gainsrealized or "
			+ "@ROC_GainsUnrealized or @Transfer_Gainsrealized or @Transfer_GainsUnrealized or @BondAmortization_Gainsrealized or @BondAmortization_GainsUnrealized or @BondAccured_Gainsrealized or "
			+ "@BondAccured_GainsUnrealized or @Merger_Gainsrealized or @DE_Merger_GainsUnrealized or @MF_Merger_GainsUnrealized or @Demerger_Gainsrealized or @Demerger_GainsUnrealized or "
			+ "@ZCB_Gainsrealized_USD or @ZCB_GainsUnrealized_USD or @Gains_FilterSummation")
	public void GAINS_Report_Check(Scenario scenario) throws Exception
	{
		@SuppressWarnings("unused")
		CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
		homePageCommon hpc = new homePageCommon(driverThread.get());
		hpc.clickOnMenuThenClickOnAnalytics();
		analytics a = new analytics(driverThread.get());
		a.clickOnGainsReportLink();
	}

	@Before("@PRIVATE_EQUITY_Report_Check or @PEReport_Existingdata or @PEReport_INR or @PEReport_INR_Withrecallable or @PEReport_INR_Withoutrecallable or @PEReport_USD or "
			+ "@PEReport_USD_Withrecallable or @PEReport_USD_Withoutrecallable or @PEReport_INRtoUSD or @PEReport_INRtoUSD_Withrecallable or @PEReport_INRtoUSD_Withoutrecallable")
	public void PRIVATE_EQUITY_Report_Check(Scenario scenario) throws Exception
	{
		@SuppressWarnings("unused")
		CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
		homePageCommon hpc = new homePageCommon(driverThread.get());
		hpc.clickOnMenuThenClickOnAnalytics();
		analytics a = new analytics(driverThread.get());
		a.clickOnPrivateEquity();
	}

	@Before("@FIReport_Existingdata")
	public void Fixed_Income_Report_Check(Scenario scenario) throws Exception
	{
		@SuppressWarnings("unused")
		CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
		homePageCommon hpc = new homePageCommon(driverThread.get());
		hpc.clickOnMenuThenClickOnAnalytics();
		analytics a = new analytics(driverThread.get());
		a.clickOnFixedIncome();
	}

	@Before("@OpenLotReport")
	public void Open_Lot_Report_Check(Scenario scenario) throws Exception
	{
		@SuppressWarnings("unused")
		CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
		homePageCommon hpc = new homePageCommon(driverThread.get());
		hpc.clickOnMenuThenClickOnAnalytics();
		analytics a = new analytics(driverThread.get());
		a.clickOnOpenLotReport();
	}

	@Before("@DerivativeReport")
	public void Derivative_Report_Check(Scenario scenario) throws Exception
	{
		@SuppressWarnings("unused")
		CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
		homePageCommon hpc = new homePageCommon(driverThread.get());
		hpc.clickOnMenuThenClickOnAnalytics();
		analytics a = new analytics(driverThread.get());
		a.clickDerivativesReport();
	}

	*//*@Before("")
	public void MultiPeriodPerformance_Report_PeriodCheck(Scenario scenario) throws Exception
	{
		@SuppressWarnings("unused")
		CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
		homePageCommon hpc = new homePageCommon(driverThread.get());
		hpc.clickOnMenuThenClickOnAnalytics();
		analytics a = new analytics(driverThread.get());
		a.clickOnMultiPeriodPerformance();
	}*//*

	@Before("@CapitalFlow")
	public void CapitalFlow_Report_Check(Scenario scenario) throws Exception
	{
		@SuppressWarnings("unused")
		CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
		homePageCommon hpc = new homePageCommon(driverThread.get());
		hpc.clickOnMenuThenClickOnAnalytics();
		analytics a = new analytics(driverThread.get());
		a.clickOnCapitalFlow();
	}

	@Before("@Test_PPR")
	public void PPR_Report_Check(Scenario scenario) throws Exception
	{
		@SuppressWarnings("unused")
		CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
		homePageCommon hpc = new homePageCommon(driverThread.get());
		hpc.clickOnMenuThenClickOnAnalytics();
		analytics a = new analytics(driverThread.get());
		a.clickOnportFolioPerformanceSummaryLink();
	}

	@Before("@Asset_Allocation_Report")
	public void AssetAllocation_Report(Scenario scenario) throws Exception
	{
		@SuppressWarnings("unused")
		CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
		homePageCommon hpc = new homePageCommon(driverThread.get());
		hpc.clickOnMenuThenClickOnAnalytics();
		analytics a = new analytics(driverThread.get());
		a.clickOnAssetAllocationLink();
	}

	@Before("@Real_Estate_Report")
	public void RealEstate_Report(Scenario scenario) throws Exception
	{
		@SuppressWarnings("unused")
		CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
		homePageCommon hpc = new homePageCommon(driverThread.get());
		hpc.clickOnMenuThenClickOnAnalytics();
		analytics a = new analytics(driverThread.get());
		a.clickOnRealEstateLink();
	}

	@Before("@PrivateAssetReport")
	public void Private_Assets_Register_Report(Scenario scenario) throws Exception
	{
		@SuppressWarnings("unused")
		CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
		homePageCommon hpc = new homePageCommon(driverThread.get());
		hpc.clickOnMenuThenClickOnAnalytics();
		analytics a = new analytics(driverThread.get());
		a.clickOnPrivateAssetRegister();
	}

	@Before("@MPPR_PHASE4")
	public void MultiPeriodPerformance_PHASE4_Report_Check(Scenario scenario) throws Exception
	{
		@SuppressWarnings("unused")
		CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
		homePageCommon hpc = new homePageCommon(driverThread.get());
		hpc.clickOnMenuThenClickOnAnalytics();
		analytics a = new analytics(driverThread.get());
		a.clickOnMultiPeriodPerformance_Phase4();
	}

	@Before("@Insurance_Summary")
	public void Insurance_Summary_Report(Scenario scenario) throws Exception
	{
		@SuppressWarnings("unused")
		CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
		homePageCommon hpc = new homePageCommon(driverThread.get());
		hpc.clickOnMenuThenClickOnAnalytics();
		analytics a = new analytics(driverThread.get());
		a.clickOnInsuranceSummaryLink();
	}

	@Before("@Investment_Payout_Register")
	public void InvestmentPayoutRegister(Scenario scenario) throws Exception {
		@SuppressWarnings("unused")
		CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
		homePageCommon hpc = new homePageCommon(driverThread.get());
		hpc.clickOnMenuThenClickOnAnalytics();
		analytics a = new analytics(driverThread.get());
		a.clickOnInvestmentPayoutRegisterLink();
	}

	@Before("@MultiPeriodPerformance or @MPPR_Autoval or @Position_MPPR or @SquareOffPosition_MPPR or @MPPR_Client_Checks")
	public void MultiPeriodPerformance_Report(Scenario scenario) throws Exception {
		@SuppressWarnings("unused")
		CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
		homePageCommon hpc = new homePageCommon(driverThread.get());
		hpc.clickOnMenuThenClickOnAnalytics();
		analytics a = new analytics(driverThread.get());
		a.clickOnMultiPeriodPerformanceBetaLink();
	}

	@Before("@Income_And_Expense_Report")
	public void IncomeAndExpenseReport(Scenario scenario) throws Exception
	{
		@SuppressWarnings("unused")
		CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
		homePageCommon hpc = new homePageCommon(driverThread.get());
		hpc.clickOnMenuThenClickOnAnalytics();
		analytics a = new analytics(driverThread.get());
		a.clickOnIncomeAndExpenseLink();
	}

	@Before("@CapitalFlowByInvestments or @CFI_FilterSummation")
	public void CapitalFlow_InvestmentReport_Check(Scenario scenario) throws Exception
	{
		@SuppressWarnings("unused")
		CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
		homePageCommon hpc = new homePageCommon(driverThread.get());
		hpc.clickOnMenuThenClickOnAnalytics();
		analytics a = new analytics(driverThread.get());
		a.clickOnCaptialFlowByInvestmentsBetaLink();
	}
*/
}
