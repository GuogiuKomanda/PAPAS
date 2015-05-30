package lt.pap.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the tof_user_settings database table.
 * 
 */
@Entity
@Table(name="tof_user_settings")
@NamedQuery(name="TofUserSetting.findAll", query="SELECT t FROM TofUserSetting t")
public class TofUserSetting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USS_ID")
	private short ussId;

	@Column(name="USS_BRAND_FILTER_ACTIVE")
	private byte ussBrandFilterActive;

	@Column(name="USS_CITY")
	private String ussCity;

	@Column(name="USS_COMPANY_NAME")
	private String ussCompanyName;

	@Column(name="USS_COU_CC")
	private String ussCouCc;

	@Column(name="USS_COU_CC_ADDRESS")
	private String ussCouCcAddress;

	@Column(name="USS_COU_ID")
	private short ussCouId;

	@Column(name="USS_COU_ID_ADDRESS")
	private short ussCouIdAddress;

	@Column(name="USS_CUSTOMER_NUMBER")
	private String ussCustomerNumber;

	@Column(name="USS_DIRECTORY")
	private String ussDirectory;

	@Column(name="USS_EMAIL")
	private String ussEmail;

	@Column(name="USS_EMAIL_ORDER_SUBJECT")
	private String ussEmailOrderSubject;

	@Column(name="USS_EMAIL_ORDER_TEXT")
	private String ussEmailOrderText;

	@Column(name="USS_ENGINE_FILTER_ACTIVE")
	private byte ussEngineFilterActive;

	@Column(name="USS_ERR_TRACK_PASSWORD")
	private String ussErrTrackPassword;

	@Column(name="USS_EXPERT_SEARCH")
	private short ussExpertSearch;

	@Column(name="USS_EXTENSION")
	private String ussExtension;

	@Column(name="USS_FAX")
	private String ussFax;

	@Column(name="USS_FILENAME")
	private String ussFilename;

	@Column(name="USS_FIRST_NAME")
	private String ussFirstName;

	@Column(name="USS_HESS_PASSWORD")
	private String ussHessPassword;

	@Column(name="USS_HESS_USER")
	private String ussHessUser;

	@Column(name="USS_HOURLY_RATE_BODY")
	private BigDecimal ussHourlyRateBody;

	@Column(name="USS_HOURLY_RATE_ELECTRONICS")
	private BigDecimal ussHourlyRateElectronics;

	@Column(name="USS_HOURLY_RATE_MECHANICS")
	private BigDecimal ussHourlyRateMechanics;

	@Column(name="USS_KIND_OF_FILTER")
	private short ussKindOfFilter;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="USS_LAST_UPDATE")
	private Date ussLastUpdate;

	@Column(name="USS_LNG_ID")
	private short ussLngId;

	@Column(name="USS_LOGO_PATH")
	private String ussLogoPath;

	@Column(name="USS_MANU_MODEL_FILTER_ACTIVE")
	private byte ussManuModelFilterActive;

	@Column(name="USS_MOBILE")
	private String ussMobile;

	@Column(name="USS_NAME")
	private String ussName;

	@Column(name="USS_NODE_WITHOUT_LINKS")
	private short ussNodeWithoutLinks;

	@Column(name="USS_POB")
	private String ussPob;

	@Column(name="USS_POSTAL_CODE")
	private String ussPostalCode;

	@Column(name="USS_POSTAL_CODE_POB")
	private String ussPostalCodePob;

	@Column(name="USS_PREFERRED_SEARCH")
	private String ussPreferredSearch;

	@Column(name="USS_PREFERRED_SECTION")
	private String ussPreferredSection;

	@Column(name="USS_PROFILE_FIRST_NAME")
	private String ussProfileFirstName;

	@Column(name="USS_PROFILE_NAME")
	private String ussProfileName;

	@Column(name="USS_PROFILE_PASSWORD")
	private String ussProfilePassword;

	@Column(name="USS_REGION")
	private String ussRegion;

	@Column(name="USS_ROLE")
	private String ussRole;

	@Column(name="USS_SHOW_CRITERIA_DIALOG")
	private short ussShowCriteriaDialog;

	@Column(name="USS_SHOW_IMPROVEMENTS_DIALOG")
	private short ussShowImprovementsDialog;

	@Column(name="USS_SHOW_LAST_AXLE")
	private short ussShowLastAxle;

	@Column(name="USS_SHOW_LAST_ENGINE")
	private short ussShowLastEngine;

	@Column(name="USS_SHOW_LAST_VEHICLE")
	private short ussShowLastVehicle;

	@Column(name="USS_SHOW_UPDATE")
	private String ussShowUpdate;

	@Column(name="USS_SIV_PASSWORD")
	private String ussSivPassword;

	@Column(name="USS_SIV_USER")
	private String ussSivUser;

	@Column(name="USS_STREE_FILTER_ACTIVE")
	private byte ussStreeFilterActive;

	@Column(name="USS_STREET")
	private String ussStreet;

	@Column(name="USS_TAX")
	private BigDecimal ussTax;

	@Column(name="USS_TAX_REDUCED")
	private BigDecimal ussTaxReduced;

	@Column(name="USS_TAX_STANDARD")
	private BigDecimal ussTaxStandard;

	@Column(name="USS_TELEPHONE")
	private String ussTelephone;

	@Column(name="USS_TITLE")
	private String ussTitle;

	@Column(name="USS_TSD_ID")
	private short ussTsdId;

	@Column(name="USS_USTID_CC")
	private String ussUstidCc;

	@Column(name="USS_USTID_NR")
	private String ussUstidNr;

	@Column(name="USS_VAT")
	private String ussVat;

	@Column(name="USS_VEHICLE_FILTER_ACTIVE")
	private byte ussVehicleFilterActive;

	@Column(name="USS_VRM_IE_PASSWORD")
	private String ussVrmIePassword;

	@Column(name="USS_VRM_IE_USER")
	private String ussVrmIeUser;

	@Column(name="USS_VRM_UK_INITIALS")
	private String ussVrmUkInitials;

	@Column(name="USS_VRM_UK_PASSWORD")
	private String ussVrmUkPassword;

	@Column(name="USS_VRM_UK_USER")
	private String ussVrmUkUser;

	@Column(name="USS_WEB")
	private String ussWeb;

	@Column(name="USS_WINDOWS_USER")
	private String ussWindowsUser;

	public TofUserSetting() {
	}

	public short getUssId() {
		return this.ussId;
	}

	public void setUssId(short ussId) {
		this.ussId = ussId;
	}

	public byte getUssBrandFilterActive() {
		return this.ussBrandFilterActive;
	}

	public void setUssBrandFilterActive(byte ussBrandFilterActive) {
		this.ussBrandFilterActive = ussBrandFilterActive;
	}

	public String getUssCity() {
		return this.ussCity;
	}

	public void setUssCity(String ussCity) {
		this.ussCity = ussCity;
	}

	public String getUssCompanyName() {
		return this.ussCompanyName;
	}

	public void setUssCompanyName(String ussCompanyName) {
		this.ussCompanyName = ussCompanyName;
	}

	public String getUssCouCc() {
		return this.ussCouCc;
	}

	public void setUssCouCc(String ussCouCc) {
		this.ussCouCc = ussCouCc;
	}

	public String getUssCouCcAddress() {
		return this.ussCouCcAddress;
	}

	public void setUssCouCcAddress(String ussCouCcAddress) {
		this.ussCouCcAddress = ussCouCcAddress;
	}

	public short getUssCouId() {
		return this.ussCouId;
	}

	public void setUssCouId(short ussCouId) {
		this.ussCouId = ussCouId;
	}

	public short getUssCouIdAddress() {
		return this.ussCouIdAddress;
	}

	public void setUssCouIdAddress(short ussCouIdAddress) {
		this.ussCouIdAddress = ussCouIdAddress;
	}

	public String getUssCustomerNumber() {
		return this.ussCustomerNumber;
	}

	public void setUssCustomerNumber(String ussCustomerNumber) {
		this.ussCustomerNumber = ussCustomerNumber;
	}

	public String getUssDirectory() {
		return this.ussDirectory;
	}

	public void setUssDirectory(String ussDirectory) {
		this.ussDirectory = ussDirectory;
	}

	public String getUssEmail() {
		return this.ussEmail;
	}

	public void setUssEmail(String ussEmail) {
		this.ussEmail = ussEmail;
	}

	public String getUssEmailOrderSubject() {
		return this.ussEmailOrderSubject;
	}

	public void setUssEmailOrderSubject(String ussEmailOrderSubject) {
		this.ussEmailOrderSubject = ussEmailOrderSubject;
	}

	public String getUssEmailOrderText() {
		return this.ussEmailOrderText;
	}

	public void setUssEmailOrderText(String ussEmailOrderText) {
		this.ussEmailOrderText = ussEmailOrderText;
	}

	public byte getUssEngineFilterActive() {
		return this.ussEngineFilterActive;
	}

	public void setUssEngineFilterActive(byte ussEngineFilterActive) {
		this.ussEngineFilterActive = ussEngineFilterActive;
	}

	public String getUssErrTrackPassword() {
		return this.ussErrTrackPassword;
	}

	public void setUssErrTrackPassword(String ussErrTrackPassword) {
		this.ussErrTrackPassword = ussErrTrackPassword;
	}

	public short getUssExpertSearch() {
		return this.ussExpertSearch;
	}

	public void setUssExpertSearch(short ussExpertSearch) {
		this.ussExpertSearch = ussExpertSearch;
	}

	public String getUssExtension() {
		return this.ussExtension;
	}

	public void setUssExtension(String ussExtension) {
		this.ussExtension = ussExtension;
	}

	public String getUssFax() {
		return this.ussFax;
	}

	public void setUssFax(String ussFax) {
		this.ussFax = ussFax;
	}

	public String getUssFilename() {
		return this.ussFilename;
	}

	public void setUssFilename(String ussFilename) {
		this.ussFilename = ussFilename;
	}

	public String getUssFirstName() {
		return this.ussFirstName;
	}

	public void setUssFirstName(String ussFirstName) {
		this.ussFirstName = ussFirstName;
	}

	public String getUssHessPassword() {
		return this.ussHessPassword;
	}

	public void setUssHessPassword(String ussHessPassword) {
		this.ussHessPassword = ussHessPassword;
	}

	public String getUssHessUser() {
		return this.ussHessUser;
	}

	public void setUssHessUser(String ussHessUser) {
		this.ussHessUser = ussHessUser;
	}

	public BigDecimal getUssHourlyRateBody() {
		return this.ussHourlyRateBody;
	}

	public void setUssHourlyRateBody(BigDecimal ussHourlyRateBody) {
		this.ussHourlyRateBody = ussHourlyRateBody;
	}

	public BigDecimal getUssHourlyRateElectronics() {
		return this.ussHourlyRateElectronics;
	}

	public void setUssHourlyRateElectronics(BigDecimal ussHourlyRateElectronics) {
		this.ussHourlyRateElectronics = ussHourlyRateElectronics;
	}

	public BigDecimal getUssHourlyRateMechanics() {
		return this.ussHourlyRateMechanics;
	}

	public void setUssHourlyRateMechanics(BigDecimal ussHourlyRateMechanics) {
		this.ussHourlyRateMechanics = ussHourlyRateMechanics;
	}

	public short getUssKindOfFilter() {
		return this.ussKindOfFilter;
	}

	public void setUssKindOfFilter(short ussKindOfFilter) {
		this.ussKindOfFilter = ussKindOfFilter;
	}

	public Date getUssLastUpdate() {
		return this.ussLastUpdate;
	}

	public void setUssLastUpdate(Date ussLastUpdate) {
		this.ussLastUpdate = ussLastUpdate;
	}

	public short getUssLngId() {
		return this.ussLngId;
	}

	public void setUssLngId(short ussLngId) {
		this.ussLngId = ussLngId;
	}

	public String getUssLogoPath() {
		return this.ussLogoPath;
	}

	public void setUssLogoPath(String ussLogoPath) {
		this.ussLogoPath = ussLogoPath;
	}

	public byte getUssManuModelFilterActive() {
		return this.ussManuModelFilterActive;
	}

	public void setUssManuModelFilterActive(byte ussManuModelFilterActive) {
		this.ussManuModelFilterActive = ussManuModelFilterActive;
	}

	public String getUssMobile() {
		return this.ussMobile;
	}

	public void setUssMobile(String ussMobile) {
		this.ussMobile = ussMobile;
	}

	public String getUssName() {
		return this.ussName;
	}

	public void setUssName(String ussName) {
		this.ussName = ussName;
	}

	public short getUssNodeWithoutLinks() {
		return this.ussNodeWithoutLinks;
	}

	public void setUssNodeWithoutLinks(short ussNodeWithoutLinks) {
		this.ussNodeWithoutLinks = ussNodeWithoutLinks;
	}

	public String getUssPob() {
		return this.ussPob;
	}

	public void setUssPob(String ussPob) {
		this.ussPob = ussPob;
	}

	public String getUssPostalCode() {
		return this.ussPostalCode;
	}

	public void setUssPostalCode(String ussPostalCode) {
		this.ussPostalCode = ussPostalCode;
	}

	public String getUssPostalCodePob() {
		return this.ussPostalCodePob;
	}

	public void setUssPostalCodePob(String ussPostalCodePob) {
		this.ussPostalCodePob = ussPostalCodePob;
	}

	public String getUssPreferredSearch() {
		return this.ussPreferredSearch;
	}

	public void setUssPreferredSearch(String ussPreferredSearch) {
		this.ussPreferredSearch = ussPreferredSearch;
	}

	public String getUssPreferredSection() {
		return this.ussPreferredSection;
	}

	public void setUssPreferredSection(String ussPreferredSection) {
		this.ussPreferredSection = ussPreferredSection;
	}

	public String getUssProfileFirstName() {
		return this.ussProfileFirstName;
	}

	public void setUssProfileFirstName(String ussProfileFirstName) {
		this.ussProfileFirstName = ussProfileFirstName;
	}

	public String getUssProfileName() {
		return this.ussProfileName;
	}

	public void setUssProfileName(String ussProfileName) {
		this.ussProfileName = ussProfileName;
	}

	public String getUssProfilePassword() {
		return this.ussProfilePassword;
	}

	public void setUssProfilePassword(String ussProfilePassword) {
		this.ussProfilePassword = ussProfilePassword;
	}

	public String getUssRegion() {
		return this.ussRegion;
	}

	public void setUssRegion(String ussRegion) {
		this.ussRegion = ussRegion;
	}

	public String getUssRole() {
		return this.ussRole;
	}

	public void setUssRole(String ussRole) {
		this.ussRole = ussRole;
	}

	public short getUssShowCriteriaDialog() {
		return this.ussShowCriteriaDialog;
	}

	public void setUssShowCriteriaDialog(short ussShowCriteriaDialog) {
		this.ussShowCriteriaDialog = ussShowCriteriaDialog;
	}

	public short getUssShowImprovementsDialog() {
		return this.ussShowImprovementsDialog;
	}

	public void setUssShowImprovementsDialog(short ussShowImprovementsDialog) {
		this.ussShowImprovementsDialog = ussShowImprovementsDialog;
	}

	public short getUssShowLastAxle() {
		return this.ussShowLastAxle;
	}

	public void setUssShowLastAxle(short ussShowLastAxle) {
		this.ussShowLastAxle = ussShowLastAxle;
	}

	public short getUssShowLastEngine() {
		return this.ussShowLastEngine;
	}

	public void setUssShowLastEngine(short ussShowLastEngine) {
		this.ussShowLastEngine = ussShowLastEngine;
	}

	public short getUssShowLastVehicle() {
		return this.ussShowLastVehicle;
	}

	public void setUssShowLastVehicle(short ussShowLastVehicle) {
		this.ussShowLastVehicle = ussShowLastVehicle;
	}

	public String getUssShowUpdate() {
		return this.ussShowUpdate;
	}

	public void setUssShowUpdate(String ussShowUpdate) {
		this.ussShowUpdate = ussShowUpdate;
	}

	public String getUssSivPassword() {
		return this.ussSivPassword;
	}

	public void setUssSivPassword(String ussSivPassword) {
		this.ussSivPassword = ussSivPassword;
	}

	public String getUssSivUser() {
		return this.ussSivUser;
	}

	public void setUssSivUser(String ussSivUser) {
		this.ussSivUser = ussSivUser;
	}

	public byte getUssStreeFilterActive() {
		return this.ussStreeFilterActive;
	}

	public void setUssStreeFilterActive(byte ussStreeFilterActive) {
		this.ussStreeFilterActive = ussStreeFilterActive;
	}

	public String getUssStreet() {
		return this.ussStreet;
	}

	public void setUssStreet(String ussStreet) {
		this.ussStreet = ussStreet;
	}

	public BigDecimal getUssTax() {
		return this.ussTax;
	}

	public void setUssTax(BigDecimal ussTax) {
		this.ussTax = ussTax;
	}

	public BigDecimal getUssTaxReduced() {
		return this.ussTaxReduced;
	}

	public void setUssTaxReduced(BigDecimal ussTaxReduced) {
		this.ussTaxReduced = ussTaxReduced;
	}

	public BigDecimal getUssTaxStandard() {
		return this.ussTaxStandard;
	}

	public void setUssTaxStandard(BigDecimal ussTaxStandard) {
		this.ussTaxStandard = ussTaxStandard;
	}

	public String getUssTelephone() {
		return this.ussTelephone;
	}

	public void setUssTelephone(String ussTelephone) {
		this.ussTelephone = ussTelephone;
	}

	public String getUssTitle() {
		return this.ussTitle;
	}

	public void setUssTitle(String ussTitle) {
		this.ussTitle = ussTitle;
	}

	public short getUssTsdId() {
		return this.ussTsdId;
	}

	public void setUssTsdId(short ussTsdId) {
		this.ussTsdId = ussTsdId;
	}

	public String getUssUstidCc() {
		return this.ussUstidCc;
	}

	public void setUssUstidCc(String ussUstidCc) {
		this.ussUstidCc = ussUstidCc;
	}

	public String getUssUstidNr() {
		return this.ussUstidNr;
	}

	public void setUssUstidNr(String ussUstidNr) {
		this.ussUstidNr = ussUstidNr;
	}

	public String getUssVat() {
		return this.ussVat;
	}

	public void setUssVat(String ussVat) {
		this.ussVat = ussVat;
	}

	public byte getUssVehicleFilterActive() {
		return this.ussVehicleFilterActive;
	}

	public void setUssVehicleFilterActive(byte ussVehicleFilterActive) {
		this.ussVehicleFilterActive = ussVehicleFilterActive;
	}

	public String getUssVrmIePassword() {
		return this.ussVrmIePassword;
	}

	public void setUssVrmIePassword(String ussVrmIePassword) {
		this.ussVrmIePassword = ussVrmIePassword;
	}

	public String getUssVrmIeUser() {
		return this.ussVrmIeUser;
	}

	public void setUssVrmIeUser(String ussVrmIeUser) {
		this.ussVrmIeUser = ussVrmIeUser;
	}

	public String getUssVrmUkInitials() {
		return this.ussVrmUkInitials;
	}

	public void setUssVrmUkInitials(String ussVrmUkInitials) {
		this.ussVrmUkInitials = ussVrmUkInitials;
	}

	public String getUssVrmUkPassword() {
		return this.ussVrmUkPassword;
	}

	public void setUssVrmUkPassword(String ussVrmUkPassword) {
		this.ussVrmUkPassword = ussVrmUkPassword;
	}

	public String getUssVrmUkUser() {
		return this.ussVrmUkUser;
	}

	public void setUssVrmUkUser(String ussVrmUkUser) {
		this.ussVrmUkUser = ussVrmUkUser;
	}

	public String getUssWeb() {
		return this.ussWeb;
	}

	public void setUssWeb(String ussWeb) {
		this.ussWeb = ussWeb;
	}

	public String getUssWindowsUser() {
		return this.ussWindowsUser;
	}

	public void setUssWindowsUser(String ussWindowsUser) {
		this.ussWindowsUser = ussWindowsUser;
	}

}