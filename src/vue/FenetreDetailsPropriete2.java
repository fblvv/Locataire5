package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controle.GestionDetailPropriete2;
import modele.BienImmobilier;
import modele.dao.DaoBienImmobilier;

public class FenetreDetailsPropriete2 extends JInternalFrame {
	
	private static final long serialVersionUID = -5616565275219625019L;
	private GestionDetailPropriete2 gestionClic;
    private JPanel contentPane;
    private JTextField champAdresse;
    private JTextField champType;
    private JTextField champCompteur;
    private JTextField champSurface;
    private JTextField champEquipements;
    private JTextField champDateDebut;
    private JTextField champDateFin;
    private JTextField champNombrePieces;
    private JTable tableLocataire;
    private JTextField champStatutOccupation;
    private JTextField champContratsServices;
    private JTextField champCommentaires;
    private JTable tablePaiements;
    private JTable tableHistorique;
    private JComboBox<String> selecteurIdBien;
    
    private static final String POLICE = "Tahoma";


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FenetreDetailsPropriete2 frame = new FenetreDetailsPropriete2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FenetreDetailsPropriete2() {
    	setMaximizable(true);
    	setIconifiable(true);
    	setClosable(true);
    	this.gestionClic = new GestionDetailPropriete2(this);
        setBounds(100, 100, 720, 775);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gblContentPane = new GridBagLayout();
        gblContentPane.columnWidths = new int[] { 266, 40, 266 };
        gblContentPane.rowHeights = new int[] { 0, 0, 0, 30 };
        gblContentPane.columnWeights = new double[] { 1.0, 0.0, 0.0 };
        gblContentPane.rowWeights = new double[] { 0.0, 0.0, 1.0 };
        contentPane.setLayout(gblContentPane);
		
		JPanel panelGauche = new JPanel();
		GridBagConstraints gbcPanelGauche = new GridBagConstraints();
		gbcPanelGauche.fill = GridBagConstraints.BOTH;
		gbcPanelGauche.insets = new Insets(0, 0, 5, 5);
		gbcPanelGauche.gridx = 0;
		gbcPanelGauche.gridy = 0;
		contentPane.add(panelGauche, gbcPanelGauche);
		GridBagLayout gblPanelGauche = new GridBagLayout();
		gblPanelGauche.columnWidths = new int[]{114, 207, 0};
		gblPanelGauche.rowHeights = new int[] {100, 0, 0, 0, 0, 0, 0, 0, 0, 30, 37, 75, 30, 0, 0, 0, 30};
		gblPanelGauche.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gblPanelGauche.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panelGauche.setLayout(gblPanelGauche);
		
		JLabel labelTypeLogement = new JLabel("Type de Logement");
		labelTypeLogement.setToolTipText("");
		labelTypeLogement.setForeground(Color.BLACK);
		labelTypeLogement.setBackground(Color.LIGHT_GRAY);
		labelTypeLogement.setFont(new Font(POLICE, Font.PLAIN, 16));
		GridBagConstraints gbcLabelTypeLogement = new GridBagConstraints();
		gbcLabelTypeLogement.gridwidth = 2;
		gbcLabelTypeLogement.insets = new Insets(0, 0, 5, 0);
		gbcLabelTypeLogement.gridx = 0;
		gbcLabelTypeLogement.gridy = 0;
		panelGauche.add(labelTypeLogement, gbcLabelTypeLogement);
		
		JLabel labelAdresse = new JLabel("Adresse:");
		labelAdresse.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbcLabelAdresse = new GridBagConstraints();
		gbcLabelAdresse.insets = new Insets(0, 0, 5, 5);
		gbcLabelAdresse.anchor = GridBagConstraints.WEST;
		gbcLabelAdresse.gridx = 0;
		gbcLabelAdresse.gridy = 1;
		panelGauche.add(labelAdresse, gbcLabelAdresse);
		
		champAdresse = new JTextField();
		champAdresse.setColumns(5);
		GridBagConstraints gbcChampAdresse = new GridBagConstraints();
		gbcChampAdresse.insets = new Insets(0, 0, 5, 0);
		gbcChampAdresse.fill = GridBagConstraints.HORIZONTAL;
		gbcChampAdresse.gridx = 1;
		gbcChampAdresse.gridy = 1;
		panelGauche.add(champAdresse, gbcChampAdresse);
		
		JLabel labelType = new JLabel("Type:");
		GridBagConstraints gbcLabelType = new GridBagConstraints();
		gbcLabelType.anchor = GridBagConstraints.WEST;
		gbcLabelType.insets = new Insets(0, 0, 5, 5);
		gbcLabelType.gridx = 0;
		gbcLabelType.gridy = 2;
		panelGauche.add(labelType, gbcLabelType);
		
		champType = new JTextField();
		champType.setColumns(5);
		GridBagConstraints gbcChampType = new GridBagConstraints();
		gbcChampType.insets = new Insets(0, 0, 5, 0);
		gbcChampType.fill = GridBagConstraints.HORIZONTAL;
		gbcChampType.gridx = 1;
		gbcChampType.gridy = 2;
		panelGauche.add(champType, gbcChampType);
		
		JLabel labelNombreCompteurs = new JLabel("Nombre de Compteurs:");
		GridBagConstraints gbcLabelNombreCompteurs = new GridBagConstraints();
		gbcLabelNombreCompteurs.anchor = GridBagConstraints.WEST;
		gbcLabelNombreCompteurs.insets = new Insets(0, 0, 5, 5);
		gbcLabelNombreCompteurs.gridx = 0;
		gbcLabelNombreCompteurs.gridy = 3;
		panelGauche.add(labelNombreCompteurs, gbcLabelNombreCompteurs);
		
		champCompteur = new JTextField();
		champCompteur.setColumns(5);
		GridBagConstraints gbcChampCompteur = new GridBagConstraints();
		gbcChampCompteur.insets = new Insets(0, 0, 5, 0);
		gbcChampCompteur.fill = GridBagConstraints.HORIZONTAL;
		gbcChampCompteur.gridx = 1;
		gbcChampCompteur.gridy = 3;
		panelGauche.add(champCompteur, gbcChampCompteur);
		
		JLabel labelSurface = new JLabel("Surface:");
		GridBagConstraints gbcLabelSurface = new GridBagConstraints();
		gbcLabelSurface.anchor = GridBagConstraints.WEST;
		gbcLabelSurface.insets = new Insets(0, 0, 5, 5);
		gbcLabelSurface.gridx = 0;
		gbcLabelSurface.gridy = 4;
		panelGauche.add(labelSurface, gbcLabelSurface);
		
		champSurface = new JTextField();
		champSurface.setColumns(5);
		GridBagConstraints gbcChampSurface = new GridBagConstraints();
		gbcChampSurface.insets = new Insets(0, 0, 5, 0);
		gbcChampSurface.fill = GridBagConstraints.HORIZONTAL;
		gbcChampSurface.gridx = 1;
		gbcChampSurface.gridy = 4;
		panelGauche.add(champSurface, gbcChampSurface);
		
		JLabel labelNombrePieces = new JLabel("Nombre de Pièces:");
		GridBagConstraints gbcLabelNombrePieces = new GridBagConstraints();
		gbcLabelNombrePieces.anchor = GridBagConstraints.WEST;
		gbcLabelNombrePieces.insets = new Insets(0, 0, 5, 5);
		gbcLabelNombrePieces.gridx = 0;
		gbcLabelNombrePieces.gridy = 5;
		panelGauche.add(labelNombrePieces, gbcLabelNombrePieces);
		
		champNombrePieces = new JTextField();
		champNombrePieces.setColumns(5);
		GridBagConstraints gbcChampNombrePieces = new GridBagConstraints();
		gbcChampNombrePieces.insets = new Insets(0, 0, 5, 0);
		gbcChampNombrePieces.fill = GridBagConstraints.HORIZONTAL;
		gbcChampNombrePieces.gridx = 1;
		gbcChampNombrePieces.gridy = 5;
		panelGauche.add(champNombrePieces, gbcChampNombrePieces);
		
		JLabel labelEquipements = new JLabel("Équipements:");
		GridBagConstraints gbcLabelEquipements = new GridBagConstraints();
		gbcLabelEquipements.anchor = GridBagConstraints.WEST;
		gbcLabelEquipements.insets = new Insets(0, 0, 5, 5);
		gbcLabelEquipements.gridx = 0;
		gbcLabelEquipements.gridy = 6;
		panelGauche.add(labelEquipements, gbcLabelEquipements);
		
		champEquipements = new JTextField();
		champEquipements.setColumns(5);
		GridBagConstraints gbcChampEquipements = new GridBagConstraints();
		gbcChampEquipements.insets = new Insets(0, 0, 5, 0);
		gbcChampEquipements.fill = GridBagConstraints.HORIZONTAL;
		gbcChampEquipements.gridx = 1;
		gbcChampEquipements.gridy = 6;
		panelGauche.add(champEquipements, gbcChampEquipements);
		
		JLabel labelDateDebut = new JLabel("Date de Début:");
		GridBagConstraints gbcLabelDateDebut = new GridBagConstraints();
		gbcLabelDateDebut.anchor = GridBagConstraints.WEST;
		gbcLabelDateDebut.insets = new Insets(0, 0, 5, 5);
		gbcLabelDateDebut.gridx = 0;
		gbcLabelDateDebut.gridy = 7;
		panelGauche.add(labelDateDebut, gbcLabelDateDebut);
		
		champDateDebut = new JTextField();
		champDateDebut.setColumns(5);
		GridBagConstraints gbcShampDateDebut = new GridBagConstraints();
		gbcShampDateDebut.insets = new Insets(0, 0, 5, 0);
		gbcShampDateDebut.fill = GridBagConstraints.HORIZONTAL;
		gbcShampDateDebut.gridx = 1;
		gbcShampDateDebut.gridy = 7;
		panelGauche.add(champDateDebut, gbcShampDateDebut);
		
		JLabel labelDateFin = new JLabel("Date de Fin:");
		GridBagConstraints gbcLabelDateFin = new GridBagConstraints();
		gbcLabelDateFin.anchor = GridBagConstraints.WEST;
		gbcLabelDateFin.insets = new Insets(0, 0, 5, 5);
		gbcLabelDateFin.gridx = 0;
		gbcLabelDateFin.gridy = 8;
		panelGauche.add(labelDateFin, gbcLabelDateFin);
		
		champDateFin = new JTextField();
		champDateFin.setColumns(5);
		GridBagConstraints gbcChampDateFin = new GridBagConstraints();
		gbcChampDateFin.insets = new Insets(0, 0, 5, 0);
		gbcChampDateFin.fill = GridBagConstraints.HORIZONTAL;
		gbcChampDateFin.gridx = 1;
		gbcChampDateFin.gridy = 8;
		panelGauche.add(champDateFin, gbcChampDateFin);
		
		JLabel labelLocatairesActuels = new JLabel("Locataires Actuels");
		labelLocatairesActuels.setFont(new Font(POLICE, Font.PLAIN, 14));
		labelLocatairesActuels.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbcLabelLocatairesActuels = new GridBagConstraints();
		gbcLabelLocatairesActuels.anchor = GridBagConstraints.WEST;
		gbcLabelLocatairesActuels.insets = new Insets(0, 0, 5, 5);
		gbcLabelLocatairesActuels.gridx = 0;
		gbcLabelLocatairesActuels.gridy = 10;
		panelGauche.add(labelLocatairesActuels, gbcLabelLocatairesActuels);
		
		JScrollPane scrollPaneLocatairesActuels = new JScrollPane((Component) null);
		GridBagConstraints gbcScrollPaneLocatairesActuels = new GridBagConstraints();
		gbcScrollPaneLocatairesActuels.insets = new Insets(0, 0, 5, 0);
		gbcScrollPaneLocatairesActuels.gridwidth = 2;
		gbcScrollPaneLocatairesActuels.fill = GridBagConstraints.BOTH;
		gbcScrollPaneLocatairesActuels.gridx = 0;
		gbcScrollPaneLocatairesActuels.gridy = 11;
		panelGauche.add(scrollPaneLocatairesActuels, gbcScrollPaneLocatairesActuels);
		
		tableLocataire = new JTable();
		tableLocataire.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "Nom", "Durée du séjour"
			}
		));
		scrollPaneLocatairesActuels.setViewportView(tableLocataire);
		
		JLabel labelStatutOccupation = new JLabel("Statut d'Occupation:");
		GridBagConstraints gbcLabelStatutOccupation = new GridBagConstraints();
		gbcLabelStatutOccupation.anchor = GridBagConstraints.WEST;
		gbcLabelStatutOccupation.insets = new Insets(0, 0, 5, 5);
		gbcLabelStatutOccupation.gridx = 0;
		gbcLabelStatutOccupation.gridy = 13;
		panelGauche.add(labelStatutOccupation, gbcLabelStatutOccupation);
		
		champStatutOccupation = new JTextField();
		champStatutOccupation.setColumns(5);
		GridBagConstraints gbcChampStatutOccupation = new GridBagConstraints();
		gbcChampStatutOccupation.insets = new Insets(0, 0, 5, 0);
		gbcChampStatutOccupation.fill = GridBagConstraints.HORIZONTAL;
		gbcChampStatutOccupation.gridx = 1;
		gbcChampStatutOccupation.gridy = 13;
		panelGauche.add(champStatutOccupation, gbcChampStatutOccupation);
		
		JLabel labelContratsServices = new JLabel("Contrats de Services:");
		GridBagConstraints gbcLabelContratsServices = new GridBagConstraints();
		gbcLabelContratsServices.anchor = GridBagConstraints.WEST;
		gbcLabelContratsServices.insets = new Insets(0, 0, 5, 5);
		gbcLabelContratsServices.gridx = 0;
		gbcLabelContratsServices.gridy = 14;
		panelGauche.add(labelContratsServices, gbcLabelContratsServices);
		
		champContratsServices = new JTextField();
		GridBagConstraints gbcChampContratsServices = new GridBagConstraints();
		gbcChampContratsServices.insets = new Insets(0, 0, 5, 0);
		gbcChampContratsServices.fill = GridBagConstraints.HORIZONTAL;
		gbcChampContratsServices.gridx = 1;
		gbcChampContratsServices.gridy = 14;
		panelGauche.add(champContratsServices, gbcChampContratsServices);
		champContratsServices.setColumns(10);
		
		JLabel labelCommentaires = new JLabel("Commentaires:");
		GridBagConstraints gbcLabelCommentaires = new GridBagConstraints();
		gbcLabelCommentaires.anchor = GridBagConstraints.WEST;
		gbcLabelCommentaires.insets = new Insets(0, 0, 0, 5);
		gbcLabelCommentaires.gridx = 0;
		gbcLabelCommentaires.gridy = 15;
		panelGauche.add(labelCommentaires, gbcLabelCommentaires);
		
		champCommentaires = new JTextField();
		GridBagConstraints gbcChampCommentaires = new GridBagConstraints();
		gbcChampCommentaires.fill = GridBagConstraints.HORIZONTAL;
		gbcChampCommentaires.gridx = 1;
		gbcChampCommentaires.gridy = 15;
		panelGauche.add(champCommentaires, gbcChampCommentaires);
		champCommentaires.setColumns(10);
		
		JPanel panelDroite = new JPanel();
	    GridBagConstraints gbcPanelDroite = new GridBagConstraints();
	    gbcPanelDroite.insets = new Insets(0, 0, 5, 0);
	    gbcPanelDroite.fill = GridBagConstraints.BOTH;
	    gbcPanelDroite.gridx = 2;
	    gbcPanelDroite.gridy = 0;
	    contentPane.add(panelDroite, gbcPanelDroite);
	    GridBagLayout gblPanelDroite = new GridBagLayout();
	    gblPanelDroite.columnWidths = new int[]{0, 0};
	    gblPanelDroite.rowHeights = new int[]{0, 30, 30, 60, 0, 0, 0, 30, 30, 30, 0};
	    gblPanelDroite.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	    gblPanelDroite.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	    panelDroite.setLayout(gblPanelDroite);
        
	 // Ajout de la JComboBox pour les ID bien
        selecteurIdBien = new JComboBox<>();
        GridBagConstraints gbcSelecteurIdBien = new GridBagConstraints();
        gbcSelecteurIdBien.ipady = 15;
        gbcSelecteurIdBien.gridheight = 2;
        gbcSelecteurIdBien.fill = GridBagConstraints.HORIZONTAL;
        gbcSelecteurIdBien.insets = new Insets(0, 0, 5, 0);
        gbcSelecteurIdBien.gridx = 0;
        gbcSelecteurIdBien.gridy = 0;
        panelDroite.add(selecteurIdBien, gbcSelecteurIdBien);
        
        
        
        
        initComboBox();
        
        
        
        
        JLabel labelHistoriquePaiements = new JLabel("Historique des Paiements:");
        labelHistoriquePaiements.setFont(new Font(POLICE, Font.PLAIN, 14));
        GridBagConstraints gbcLabelHistoriquePaiements = new GridBagConstraints();
        gbcLabelHistoriquePaiements.anchor = GridBagConstraints.WEST;
        gbcLabelHistoriquePaiements.insets = new Insets(0, 0, 5, 0);
        gbcLabelHistoriquePaiements.gridx = 0;
        gbcLabelHistoriquePaiements.gridy = 2;
        panelDroite.add(labelHistoriquePaiements, gbcLabelHistoriquePaiements);
        
        JScrollPane scrollPaneHistoriquePaiements = new JScrollPane();
        GridBagConstraints gbcScrollPaneHistoriquePaiements = new GridBagConstraints();
        gbcScrollPaneHistoriquePaiements.fill = GridBagConstraints.BOTH;
        gbcScrollPaneHistoriquePaiements.insets = new Insets(0, 0, 5, 0);
        gbcScrollPaneHistoriquePaiements.gridx = 0;
        gbcScrollPaneHistoriquePaiements.gridy = 3;
        panelDroite.add(scrollPaneHistoriquePaiements, gbcScrollPaneHistoriquePaiements);
        
        tablePaiements = new JTable();
        tablePaiements.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},

        	},
        	new String[] {
        		"Date", "Montant", "Mode de paiement"
        	}
        ));
        scrollPaneHistoriquePaiements.setViewportView(tablePaiements);
        
        JLabel labelHistoriqueReparations = new JLabel("Historique des Réparations:");
        labelHistoriqueReparations.setFont(new Font(POLICE, Font.PLAIN, 14));
        GridBagConstraints gbcLabelHistoriqueReparations = new GridBagConstraints();
        gbcLabelHistoriqueReparations.anchor = GridBagConstraints.WEST;
        gbcLabelHistoriqueReparations.insets = new Insets(0, 0, 5, 0);
        gbcLabelHistoriqueReparations.gridx = 0;
        gbcLabelHistoriqueReparations.gridy = 5;
        panelDroite.add(labelHistoriqueReparations, gbcLabelHistoriqueReparations);
        
        JScrollPane scrollPaneHistoriqueReparations = new JScrollPane();
        GridBagConstraints gbcScrollPaneHistoriqueReparations = new GridBagConstraints();
        gbcScrollPaneHistoriqueReparations.fill = GridBagConstraints.BOTH;
        gbcScrollPaneHistoriqueReparations.insets = new Insets(0, 0, 5, 0);
        gbcScrollPaneHistoriqueReparations.gridx = 0;
        gbcScrollPaneHistoriqueReparations.gridy = 6;
        panelDroite.add(scrollPaneHistoriqueReparations, gbcScrollPaneHistoriqueReparations);
        
        tableHistorique = new JTable();
        tableHistorique.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        	},
        	new String[] {
        		"Date", "Description", "Co\u00FBt"
        	}
        ));
        scrollPaneHistoriqueReparations.setViewportView(tableHistorique);
        
        JPanel panelButton = new JPanel();
        GridBagConstraints gbcPanelButton = new GridBagConstraints();
        gbcPanelButton.insets = new Insets(0, 0, 5, 5);
        gbcPanelButton.fill = GridBagConstraints.BOTH;
        gbcPanelButton.gridx = 0;
        gbcPanelButton.gridy = 2;
        contentPane.add(panelButton, gbcPanelButton);
        
        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.setHorizontalAlignment(SwingConstants.LEFT);
        panelButton.add(btnAnnuler);
        btnAnnuler.addActionListener(this.gestionClic);
        
        JButton btnAutreSection = new JButton("Autre Section");
        btnAutreSection.setHorizontalAlignment(SwingConstants.RIGHT);
        panelButton.add(btnAutreSection);
    }
    
    
    private void initComboBox() {
        DaoBienImmobilier daoBienImmobilier = new DaoBienImmobilier();
        try {
 
            Collection<BienImmobilier> biens = daoBienImmobilier.findAll();


            String[] ids = new String[biens.size()];

            int i = 0;
            for (BienImmobilier bien : biens) {
                ids[i] = bien.getId_Bien_Imm();
                i++;
            }


            selecteurIdBien.setModel(new DefaultComboBoxModel<>(ids));


            selecteurIdBien.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        gestionClic.afficherInfoLogement();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
          
                    }
                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        
        }
    }

    
    
    
    public String getSelecteurIdBien() {
	    return (String) selecteurIdBien.getSelectedItem();
	   }

	public JTextField getChampAdresse() {
		return champAdresse;
	}

	public void setChampAdresse(String adresse) {
		this.champAdresse.setText(adresse);
	}

	public JTextField  getChampType() {
		return champType;
	}

	public void setChampType(JTextField champType) {
		this.champType = champType;
	}

	public JTextField getChampCompteur() {
		return champCompteur;
	}

	public void setChampCompteur(JTextField champCompteur) {
		this.champCompteur = champCompteur;
	}

	public JTextField getChampSurface() {
		return champSurface;
	}

	public void setChampSurface(JTextField champSurface) {
		this.champSurface = champSurface;
	}

	public JTextField getChampEquipements() {
		return champEquipements;
	}

	public void setChampEquipements(JTextField champEquipements) {
		this.champEquipements = champEquipements;
	}

	public JTextField getChampDateDebut() {
		return champDateDebut;
	}

	public void setChampDateDebut(JTextField champDateDebut) {
		this.champDateDebut = champDateDebut;
	}

	public JTextField getChampDateFin() {
		return champDateFin;
	}

	public void setChampDateFin(JTextField champDateFin) {
		this.champDateFin = champDateFin;
	}

	public JTextField getChampNombrePieces() {
		return champNombrePieces;
	}

	public void setChampNombrePieces(JTextField champNombrePieces) {
		this.champNombrePieces = champNombrePieces;
	}

	public JTextField getChampStatutOccupation() {
		return champStatutOccupation;
	}

	public void setChampStatutOccupation(JTextField champStatutOccupation) {
		this.champStatutOccupation = champStatutOccupation;
	}

	public JTextField getChampContratsServices() {
		return champContratsServices;
	}

	public void setChampContratsServices(JTextField champContratsServices) {
		this.champContratsServices = champContratsServices;
	}

	public JTextField getChampCommentaires() {
		return champCommentaires;
	}

	public void setChampCommentaires(JTextField champCommentaires) {
		this.champCommentaires = champCommentaires;
	}
	
	public JTable getTableLocataire() {
		return tableLocataire;
	}
	
	public JTable getTablePaiement() {
		return tablePaiements;
	}
	
	

}