package TD.controller;

import java.awt.Graphics;


import TD.model.CellContainer_Model;
import TD.model.GridCell_Model;
import TD.model.PlayScreen_Model;
import TD.model.Shop_Model;
import TD.view.CellContainer_View;
import TD.view.GridCell_View;
import TD.view.PlayScreen_View;
import TD.view.Shop_View;

/**
 * This Class will bind and initialize Model-View of Play Screen Module.
 * 
 */
public class PlayScreen_Controller {

    PlayScreen_Model theModel;
    PlayScreen_View theView;
    
    private CellContainer_Model ccModel;
    private CellContainer_View ccView;
    private CellContainer_Controller ccCont;
    
    GridCell_Model[][] gcModel;
    GridCell_View gcView;
    GridCell_Controller gcCont;
    
    private Shop_Model sModel;
    Shop_View sView;
    private Shop_Controller sCont;
    
    /**
     * This method is constructor for Play Screen Controller. It will initialize different views,model and controller.
     * @param psView the PlayScreenView
     * @param psModel the PlayScreenModel
     * @param gcView the GridCellView
     * @param gcModel the GridCellModel
     * @param ccView the CellContainerView
     * @param ccModel the CellContainerModel
     * @param sView the ShopView
     * @param sModel the ShopModel
     */
    
    public PlayScreen_Controller(PlayScreen_View psView, PlayScreen_Model psModel, GridCell_View gcView, GridCell_Model[][] gcModel, CellContainer_View ccView, CellContainer_Model ccModel, Shop_View sView, Shop_Model sModel) {
        theModel = psModel;
        theView = psView;
        
        this.gcModel = gcModel;
        this.gcView = gcView;
        this.gcCont = new GridCell_Controller(this.gcView,this.gcModel);
        
        this.ccView = ccView;
        this.ccModel = ccModel;
        this.ccCont = new CellContainer_Controller(this.getCcView(), this.getCcModel());
        this.ccCont.setgcCont(gcCont);
        
        this.ccView.setCcCont(ccCont);
        this.ccCont.setgcCont(gcCont);
        ccModel = theModel.getCellContainer_Model();
        
        this.sModel = sModel;
        this.sView = sView;
        sCont = new Shop_Controller(this.getsModel(),this.sView);
        sCont.setccCont(ccCont);
    }

    
    /**
     * This method will call draw() method of Cell Container Controller
     * @param g the Graphics
     */
    public void getccDraw(Graphics g){
            getCcCont().getDraw(g);
    }
    /**
     * This method will call draw() method of Shop View
     * @param g the Graphics
     */
    public void getshopDraw(Graphics g){
        getsCont().getshopDraw(getsModel(), g);
    }

    /**
     * @return the ccModel
     */
    public CellContainer_Model getCcModel() {
        return ccModel;
    }

    /**
     * @return the ccView
     */
    public CellContainer_View getCcView() {
        return ccView;
    }

    /**
     * @return the ccCont
     */
    public CellContainer_Controller getCcCont() {
        return ccCont;
    }

    /**
     * @return the sCont
     */
    public Shop_Controller getsCont() {
        return sCont;
    }

    /**
     * @return the sModel
     */
    public Shop_Model getsModel() {
        return sModel;
    }
}

